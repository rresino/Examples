package com.rresino.learn.promises;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * Created by rresino on 13/10/2016.
 */
public class FutureTaskExample {

    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) {

        System.out.println("Create future task:");
        FutureTask<String> getName = new FutureTask<String>(() -> {
            sleep(SLEEP_TIME);
            return "my name";
        });

        System.out.println("Run");

        Thread t = new Thread(()-> {
            getName.run();

            try {
                System.out.println("Response: "+getName.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();

    }

}
