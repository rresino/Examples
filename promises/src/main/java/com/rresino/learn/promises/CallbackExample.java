package com.rresino.learn.promises;

import java.util.function.Consumer;

import static java.lang.Thread.sleep;

/**
 * Created by rresino on 14/10/2016.
 */
public class CallbackExample {

    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            new RunnableCallback(x -> System.out.println(x)).run();
        });
        t.start();
    }

    private static class RunnableCallback implements Runnable {

        private final Consumer<String> callback;

        public RunnableCallback(Consumer<String> callback) {
            this.callback = callback;
        }

        @Override
        public void run() {
            try {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            callback.accept("FutureCallback");
        }

    }
}