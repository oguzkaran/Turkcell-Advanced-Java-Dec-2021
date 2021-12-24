/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte Runnable olmayan bir sınıfın bir metodu thread akışı olarak verilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;
import java.util.stream.IntStream;

class App {
    public static void main(String[] args)
    {
        var gen = new RandomGenerator(10, 1000);
        var thread = new Thread(gen::run);

        thread.start();
    }
}

class RandomGenerator {
    private final int m_count;
    private final long m_sleepMS;
    private final Random m_random = new Random();

    private void callback(int i)
    {
        Console.write("%d ", m_random.nextInt(100));
        ThreadUtil.sleep(m_sleepMS);
    }

    public RandomGenerator(int count, long sleepMS)
    {
        m_count = count;
        m_sleepMS = sleepMS;
    }

    public void run()
    {
        IntStream.range(0, m_count).forEach(this::callback);
    }
}