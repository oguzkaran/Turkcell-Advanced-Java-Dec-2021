package com.turkcell.app.concurrent.random;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGeneratorTotal {
    private long m_total;
    private int m_count;
    private final int m_stopValue;
    private final int m_min;
    private final int m_max;
    private final int m_maxCount;
    private final int m_threadCount;
    private final ArrayList<Thread> m_threads;

    private void createThreads()
    {
        for (var i = 0; i < m_threadCount; ++i) {
            var t = new Thread(this::threadCallback);

            t.start();
            m_threads.add(t);
        }
    }

    public void joinThreads()
    {
        try {
            for (var thread : m_threads)
                thread.join();
        }
        catch (InterruptedException ignore) {

        }
    }

    private void threadCallback()
    {
        var random = ThreadLocalRandom.current();

        for (var i = 0; i < m_maxCount; ++i) {
            synchronized (this) {
                var val = random.nextInt(m_min, m_max + 1);

                if (val == m_stopValue)
                    break;

                m_total += val;
                ++m_count;
            }
        }
    }

    public RandomGeneratorTotal(int stopValue, int min, int max, int maxCount, int threadCount)
    {
        m_stopValue = stopValue;
        m_min = min;
        m_max = max;
        m_maxCount = maxCount;
        m_threadCount = threadCount;
        m_threads = new ArrayList<>();
    }

    public long getTotal()
    {
        return m_total;
    }

    public int getCount()
    {
        return m_count;
    }

    public void run()
    {
        createThreads();
        joinThreads();
    }
}
