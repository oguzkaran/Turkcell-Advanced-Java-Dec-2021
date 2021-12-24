package org.csystem.app.randompasswd.runner;

import org.csystem.app.randompasswd.generator.RandomPasswordsToFileGenerator;
import org.csystem.util.console.CommandLineArgsUtil;
import org.csystem.util.console.Console;

import java.io.IOException;
import java.util.stream.IntStream;

public class RandomPasswordGeneratorApp {
    private static RandomPasswordsToFileGenerator mapCallback(int i, long n, int min, int max)
    {
        return new RandomPasswordsToFileGenerator("passwd-" + i + ".txt", n, min, max);
    }

    private static void handleGenerator(RandomPasswordsToFileGenerator generator)
    {
        try {
            generator.run();
        }
        catch (IllegalArgumentException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
    }

    private static void generateCallback(RandomPasswordsToFileGenerator generator)
    {
        var thread = new Thread(() -> handleGenerator(generator));

        thread.start();
    }

    public static void run(String [] args)
    {
        //count n min max
        CommandLineArgsUtil.checkForLengthEqual(args, 4, "Wrong number of arguments", 1);

        try {
            var count = Integer.parseInt(args[0]);
            var n = Long.parseLong(args[1]);
            var min = Integer.parseInt(args[2]);
            var max = Integer.parseInt(args[3]);

            IntStream.range(0, count).mapToObj(i -> mapCallback(i, n, min, max))
                    .forEach(RandomPasswordGeneratorApp::generateCallback);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (Throwable ignore) {
            Console.Error.writeLine("Internal Problem");
        }
    }
}
