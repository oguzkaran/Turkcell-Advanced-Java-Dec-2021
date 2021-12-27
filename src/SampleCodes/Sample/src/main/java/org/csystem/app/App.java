/*----------------------------------------------------------------------------------------------------------------------
    TODO:
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

class App {
    public static void main(String[] args)
    {
        Runnable runnable = () -> {
            var self = Thread.currentThread();
            for (int i = 0; !Thread.interrupted(); ++i)
                Console.write("First Loop:%d%n", i);

            for (int i = 0; !self.isInterrupted(); ++i)
                Console.write("Second Loop:%d%n", i);

            Console.writeLine("Thread ends!...");
        };

        var t = new Thread(runnable);

        t.start();
        ThreadUtil.sleep(3000);
        t.interrupt();
        ThreadUtil.sleep(3000);
        t.interrupt();
    }
}

