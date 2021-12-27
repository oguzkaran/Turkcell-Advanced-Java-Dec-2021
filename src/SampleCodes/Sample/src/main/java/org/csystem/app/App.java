/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte m_stop volatile yapılmazsa flag değeri true yapıldığında bazı sistemlerde runThread metoduna
    ilişkin thread sonlanmayabilir. Çünkü Java derleyicisi ve çalışma zamanında makine koduna dönüştürülmesi işlemi
    sırasında (jit (just in time compilation) m_stop değeri bir register'a çekilmiş ve sürekli registerdan alınacak
    şekilde optimize edilmiş olabilir. Şüphesiz örnek interrupt metotlarıyla da yapılabilir. Burada tamamen konuyu
    anlatmak için bu şekilde yazılmıştır. Senkronizasyon yapılırsa zaten böyle bir durum oluşmaz. Dolayısıyla volatile
    yapmaya gerek kalmaz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

class App {
    public static void main(String[] args)
    {
        var st = new StopThreadWithFlag();

        st.run();
    }
}

class StopThreadWithFlag {
    private volatile boolean m_stop;

    private void runThread()
    {
        while (!m_stop)
            Console.writeLine("I am running");
    }

    private void stopperThread()
    {
        ThreadUtil.sleep(5000);
        m_stop = true;
    }

    public void run()
    {
        new Thread(this::runThread).start();
        new Thread(this::stopperThread).start();
    }
}

