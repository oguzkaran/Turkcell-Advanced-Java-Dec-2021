package com.turkcell.app.concurrent.random;

import org.csystem.util.string.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.*;

public class RandomPasswordGenerator {
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
        for (var i = 0; i < m_threadCount; ++i)
            m_futures.add(m_threadPool.submit(this::threadCallback));
    }

    private void cancelTasks()
    {
        for (var future : m_futures)
            future.cancel(true);
    }

    private void awaitFutures() throws ExecutionException, InterruptedException
    {
        for (var future : m_futures)
            future.get();
    }

    private void awaitFutures(long timout, TimeUnit unit) throws TimeoutException, ExecutionException, InterruptedException
    {
        try {
            for (var future : m_futures)
                future.get(timout, unit);
        }
        catch (TimeoutException ex) {
            cancelTasks();
            throw ex;
        }
    }

    private void threadCallback()
    {
        for (var i = 0; i < m_count && !Thread.interrupted(); ++i)
            m_passwords.add(StringUtil.getRandomTextEN(m_random, m_random.nextInt(m_max - m_min + 1) + m_min));
    }

    public RandomPasswordGenerator(ExecutorService threadPool, int count, int min, int max, int threadCount)
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
    }

    public List<Future<?>> getFutures()
    {
        return m_futures;
    }

    public void await() throws ExecutionException, InterruptedException
    {
        awaitFutures();
    }

    public void await(long timout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException
    {
        awaitFutures(timout, unit);
    }

    public List<String> awaitAndGet() throws ExecutionException, InterruptedException
    {
        await();

        return m_passwords;
    }

    public List<String> awaitAndGet(long timout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException
    {
        await(timout, unit);

        return m_passwords;
    }
}
