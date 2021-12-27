package org.csystem.app.pc;

import org.csystem.util.thread.ThreadUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Producer {
    private final ExecutorService m_threadPool;
    private final SharedObject m_sharedObject;
    private final Random m_random;

    private void producerCallback()
    {
        int i = 0;

        for (;;) {
            ThreadUtil.sleep(Math.abs(m_random.nextInt(300)) + 200);
            m_sharedObject.setVal(i);
            if (i == 99)
                break;
            ++i;
        }
    }

    public Producer(ExecutorService threadPool, SharedObject sharedObject, Random random)
    {
        m_threadPool = threadPool;
        m_sharedObject = sharedObject;
        m_random = random;
    }

    public void run()
    {
        m_threadPool.execute(this::producerCallback);
    }
}
