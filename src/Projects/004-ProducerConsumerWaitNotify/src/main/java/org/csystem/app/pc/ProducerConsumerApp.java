package org.csystem.app.pc;

import java.util.Random;
import java.util.concurrent.Executors;

public class ProducerConsumerApp {
    public static void run(String [] args)
    {
        try {
            var random1 = new Random();
            var random2 = new Random();
            var sharedObject = new SharedObject();
            var threadPool = Executors.newFixedThreadPool(2);

            var producer = new Producer(threadPool, sharedObject, random1);
            var consumer = new Consumer(threadPool, sharedObject, random2);

            producer.run();
            consumer.run();

            threadPool.shutdown();
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
