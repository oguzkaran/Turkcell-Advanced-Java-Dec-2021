package org.csystem.app.pc;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;
import java.util.concurrent.ExecutorService;

public class Consumer {
    private final ExecutorService m_threadPool;
    private final SharedObject m_sharedObject;
    private final Random m_random;

    private void consumerCallback()
    {
        int val;

        for (;;) {
            ThreadUtil.sleep(Math.abs(m_random.nextInt(300)) + 200);
            val = m_sharedObject.getVal();
            Console.write("%d ", val);
            if (val == 99)
                break;

        }
        Console.writeLine();
    }

    public Consumer(ExecutorService threadPool, SharedObject sharedObject, Random random)
    {
        m_threadPool = threadPool;
        m_sharedObject = sharedObject;
        m_random = random;
    }

    public void run()
    {
        m_threadPool.execute(this::consumerCallback);
    }
}
