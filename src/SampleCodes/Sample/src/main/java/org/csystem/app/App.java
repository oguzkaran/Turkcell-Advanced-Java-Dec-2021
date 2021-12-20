/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte totali, komut satırı argümanı ile alınan miktarda küçük olan ve isminde - karakteri bulunan ürünlerin
    stoktaki miktarları elde edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.turkcell.app.entity.ProductInfo;
import com.turkcell.app.factory.ProductFactory;
import org.csystem.util.console.CommandLineArgsUtil;
import org.csystem.util.console.Console;

import java.math.BigDecimal;

class App {
    public static void main(String[] args)
    {
        try {
            CommandLineArgsUtil.checkForLengthEqual(args, 2, "Geçersiz sayıda argüman", 1);
            var factory = ProductFactory.loadFromTextFile(args[0]);

            if (factory.isEmpty())
                return;

            var products = factory.get().PRODUCTS;
            var value = Double.parseDouble(args[1]);
            var text = "-";

            products.stream()
                    .filter(p -> p.getTotal().compareTo(BigDecimal.valueOf(value)) < 0)
                    .filter(p -> p.getName().contains(text))
                    .map(ProductInfo::getCost)
                    .forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}