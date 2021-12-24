/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte yaş eğişk değerine göre küçük olanlar ve büyük olanlar bölümlenmiştir (partition)
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.turkcell.app.entity.MaritalStatus;
import com.turkcell.app.entity.Person;
import com.turkcell.app.factory.PersonFactory;
import org.csystem.util.console.CommandLineArgsUtil;
import org.csystem.util.console.Console;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class App {
    public static void main(String[] args)
    {
        try {
            CommandLineArgsUtil.checkForLengthEqual(args, 1, "Geçersiz sayıda argüman", 1);
            var factory = PersonFactory.loadFromTextFile(Path.of(args[0]));
            var people = factory.PEOPLE;

            Map<MaritalStatus, List<Person>> map = people.stream()
                    .collect(Collectors.groupingBy(Person::getMaritalStatus));

            if (map.containsKey(MaritalStatus.SINGLE)) {
                Console.writeLine("Bekar kişiler:");
                map.get(MaritalStatus.SINGLE).forEach(Console::writeLine);
            }
            else
                Console.writeLine("Hiç bekar kişi yok");

            Console.writeLine("-------------------------------------------------------------------------------");

            if (map.containsKey(MaritalStatus.MARRIED)) {
                Console.writeLine("Evli kişiler:");
                map.get(MaritalStatus.MARRIED).forEach(Console::writeLine);
            }
            else
                Console.writeLine("Hiç evli kişi yok");


            Console.writeLine("-------------------------------------------------------------------------------");

            if (map.containsKey(MaritalStatus.DIVORCED)) {
                Console.writeLine("Boşanmış kişiler:");
                map.get(MaritalStatus.DIVORCED).forEach(Console::writeLine);
            }
            else
                Console.writeLine("Hiç boşanmış kişi yok");

            Console.writeLine("-------------------------------------------------------------------------------");

            if (map.containsKey(MaritalStatus.WIDOW)) {
                Console.writeLine("Dul kişiler:");
                map.get(MaritalStatus.SINGLE).forEach(Console::writeLine);
            }
            else
                Console.writeLine("Hiç dul kişi yok");
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
