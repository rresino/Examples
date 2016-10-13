package com.rresino.learn.promises;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

/**
 * Created by rresino on 14/10/2016.
 */
public class PromiseFulfilExample {

    public static void main(String[] args) {
        System.out.println("Init main");
        final CompletableFuture<String> future =  new CompletableFuture<>();

        future.thenAccept(x -> System.out.println(x));

        new Thread(() -> {
            try {
                sleep(2000);
                future.complete("Hello man!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();
        System.out.println("End main");
    }
}
