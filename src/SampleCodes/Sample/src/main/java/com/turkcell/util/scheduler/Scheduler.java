package com.turkcell.util.scheduler;

import com.turkcell.util.function.IRunnable;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final Timer m_timer;
    private final long m_period;
    private final long m_delay;

    public Scheduler(long period, TimeUnit timeUnit)
    {
        this(0, period, timeUnit);
    }

    public Scheduler(long delay, long period, TimeUnit timeUnit)
    {
        m_timer = new Timer();
        m_delay = TimeUnit.MILLISECONDS.convert(delay, timeUnit);
        m_period = TimeUnit.MILLISECONDS.convert(period, timeUnit);
    }

    public void schedule(IRunnable runnable)
    {
        var task = new TimerTask() {
            @Override
            public void run()
            {
                try {
                    runnable.run();
                }
                catch (Exception ignore) {

                }
            }
        };

        m_timer.scheduleAtFixedRate(task, m_delay, m_period);
    }

    public void cancel()
    {
        m_timer.cancel();
    }
}
