/*----------------------------------------------------------------------------------------------------------------------
     Aşağdıdaki örnekte Collections sınıfının synchronizedList metodu kullanılarak senkronizasyon problemi çözülmüştür
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.turkcell.app.random.RandomGenerator;
import org.csystem.util.console.Console;

class App {
    public static void main(String[] args)
    {
        var rg = new RandomGenerator(1_000_000, 10, 20, 5);

        rg.run();

        Console.writeLine("Size:%d", rg.getPasswords().size());
    }
}

