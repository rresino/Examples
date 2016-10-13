package com.rresino.learn.promises;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.lang.Thread.sleep;

/**
 * Created by rresino on 14/10/2016.
 */
public class PromiseExample {

    public static void main(String[] args) {
        System.out.println("Init main");
        final CompletableFuture<String> getCacheValue = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, I'm a promise.";
        });

        getCacheValue.thenAccept(x -> System.out.println(x));

        new Thread(() -> {
            try {
                getCacheValue.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).run();
        System.out.println("End main");
    }
}
