/*----------------------------------------------------------------------------------------------------------------------
    Thread sınıfının static isInterrupted metodu çağrıldığı thread işterrupt flag değeri set edilmişse true, edilmemişse
    false değerine geri döner. Aşaıdaki örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

class App {
    public static void main(String[] args)
    {
        Runnable runnable = () -> {
            var self = Thread.currentThread();
            for (int i = 0; !self.isInterrupted(); ++i)
                Console.write("%d ", i);
        };

        var t = new Thread(runnable);

        t.start();
        ThreadUtil.sleep(3000);
        t.interrupt();
    }
}

