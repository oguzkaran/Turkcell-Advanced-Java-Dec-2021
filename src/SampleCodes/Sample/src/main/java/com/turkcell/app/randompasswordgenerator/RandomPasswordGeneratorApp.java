package com.turkcell.app.randompasswordgenerator;

import com.turkcell.util.scheduler.Scheduler;
import org.csystem.util.console.CommandLineArgsUtil;
import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public final class RandomPasswordGeneratorApp {
    private static int m_count;

    private static void generatePasswordCallback(Scheduler scheduler, String path, int count, int min, int max, Random r) throws IOException
    {
        try (var bw = new BufferedWriter(new FileWriter(path, true))){
            bw.write(StringUtil.getRandomTextEN(r, r.nextInt(max - min + 1) + min) + "\r\n");
            if (++m_count == count) {
                scheduler.cancel();
                bw.close();
            }
            bw.flush();
        }
    }

    public static void run(String [] args)
    {
        CommandLineArgsUtil.checkForLengthEqual(args, 4, "Wrong number of arguments", 1);

        try {
            var scheduler = new Scheduler(1, TimeUnit.SECONDS);
            var r = new Random();
            var count = Integer.parseInt(args[1]);
            var min = Integer.parseInt(args[2]);
            var max = Integer.parseInt(args[3]);
            if (!Files.exists(Path.of(args[0]))) {
                Console.Error.writeLine("File not found");
                System.exit(1);
            }

            scheduler.schedule(() -> generatePasswordCallback(scheduler, args[0], count, min, max, r)); //error
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid numbers");
        }
    }
}