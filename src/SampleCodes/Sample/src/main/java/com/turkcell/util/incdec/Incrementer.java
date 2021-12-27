package com.turkcell.util.incdec;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Incrementer {
    private final AtomicLong m_val;
    private final int m_threadCount;
    private final long m_count;

    private void threadCallback()
    {
        for (var i = 0L; i < m_count; ++i)
            m_val.incrementAndGet();
    }

    public Incrementer(int threadCount, long count)
    {
        m_val = new AtomicLong();
        m_threadCount = threadCount;
        m_count = count;
    }

    public long getVal()
    {
        return m_val.get();
    }

    public void run()
    {
        var threads = new ArrayList<Thread>();

        for (var i = 0; i < m_threadCount; ++i) {
            var t = new Thread(this::threadCallback);

            t.start();
            threads.add(t);
        }

        try {
            for (var thread : threads)
                thread.join();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
