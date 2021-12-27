package com.turkcell.app.random;

import org.csystem.util.string.StringUtil;

import java.util.*;

public class RandomGenerator {
    private final int m_count;
    private final int m_min;
    private final int m_max;
    private final int m_threadCount;
    private final List<String> m_passwords;
    private final ArrayList<Thread> m_threads;
    private final Random m_random;

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
        for (var i = 0; i < m_count; ++i)
            m_passwords.add(StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_max - m_min + 1) + m_min));
    }

    public RandomGenerator(int count, int min, int max, int threadCount)
    {
        m_count = count;
        m_min = min;
        m_max = max;
        m_threadCount = threadCount;
        m_threads = new ArrayList<>();
        m_passwords = new Vector<>();
        m_random = new Random();
    }

    public List<String> getPasswords()
    {
        return m_passwords;
    }

    public void run()
    {
        createThreads();
        joinThreads();
    }
}
