package org.csystem.app.pc;

import org.csystem.util.thread.ThreadUtil;

import java.util.concurrent.Semaphore;

public class SharedObject {
    private int m_val = -1;
    private final Semaphore m_producerSemaphore = new Semaphore(1);
    private final Semaphore m_consumerSemaphore = new Semaphore(0);

    public void setVal(int val)
    {
        ThreadUtil.acquire(m_producerSemaphore);
        m_val = val;
        ThreadUtil.release(m_consumerSemaphore);
    }

    public int getVal()
    {
        int val;

        ThreadUtil.acquire(m_consumerSemaphore);
        val = m_val;
        ThreadUtil.release(m_producerSemaphore);

        return val;
    }
}
