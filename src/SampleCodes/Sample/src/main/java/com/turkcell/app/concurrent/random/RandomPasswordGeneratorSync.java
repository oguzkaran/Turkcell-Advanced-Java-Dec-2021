package com.turkcell.app.concurrent.random;

import org.csystem.util.string.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class RandomPasswordGeneratorSync {
    private final int m_count;
    private final int m_min;
    private final int m_max;
    private final int m_threadCount;
    private final List<String> m_passwords;
    private final List<Future<?>> m_futures;
    private final Random m_random;
    private final ExecutorService m_threadPool;

    private void submitThreads()
    {
        for (var i = 0; i < m_threadCount; ++i) {
            m_futures.add(m_threadPool.submit(this::threadCallback));
        }
    }

    private void awaitFutures()
    {
        try {
            for (var future : m_futures)
                future.get();
        }
        catch (ExecutionException | InterruptedException ignore) {

        }
    }

    private void threadCallback()
    {
        for (var i = 0; i < m_count; ++i)
            m_passwords.add(StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_max - m_min + 1) + m_min));
    }

    public RandomPasswordGeneratorSync(ExecutorService threadPool, int count, int min, int max, int threadCount)
    {
        m_count = count;
        m_min = min;
        m_max = max;
        m_threadCount = threadCount;
        m_passwords = new Vector<>();
        m_futures = new ArrayList<>();
        m_random = new Random();
        m_threadPool = threadPool;
    }

    public List<String> getPasswords()
    {
        return m_passwords;
    }

    public void run()
    {
        submitThreads();
        awaitFutures();
    }
}
