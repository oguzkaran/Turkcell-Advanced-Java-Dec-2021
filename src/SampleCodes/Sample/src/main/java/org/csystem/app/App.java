/*----------------------------------------------------------------------------------------------------------------------
     Bazı durumlarda synchronized deyimi için bir nesne yokda Object türünden nesne yaratılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;

import java.util.ArrayList;

class App {
    public static void main(String[] args)
    {
        var id = new IncrementerDecrementer(3, 10_000_000);

        id.run();

        Console.writeLine("val = %d", id.getVal());
    }
}

class IncrementerDecrementer {
    private int m_val;
    private final int m_threadCount;
    private final long m_count;
    private final ArrayList<Thread> m_threads;

    private void createThreads(Runnable runnable)
    {
        for (var i = 0; i < m_threadCount; ++i) {
            var t = new Thread(runnable);

            t.start();
            m_threads.add(t);
        }
    }

    private void incrementThreadCallback()
    {
        for (var i = 0L; i < m_count; ++i)
            synchronized (this) {
                ++m_val;
            }
    }

    private void decrementThreadCallback()
    {
        for (var i = 0L; i < m_count; ++i)
            synchronized (this) {
                --m_val;
            }
    }

    private void joinThreads()
    {
        try {
            for (var thread : m_threads)
                thread.join();
        }
        catch (InterruptedException ignore) {

        }
    }

    public IncrementerDecrementer(int threadCount, long count)
    {
        m_threadCount = threadCount;
        m_count = count;
        m_threads = new ArrayList<>();
    }

    public int getVal()
    {
        return m_val;
    }

    public void run()
    {
        createThreads(this::incrementThreadCallback);
        createThreads(this::decrementThreadCallback);
        joinThreads();
    }
}

