package com.assesment;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
	private final String name;
    private final CountDownLatch latch;

    public Task(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is starting.");
            // Simulate some work with Thread.sleep()
            Thread.sleep(1000);
            System.out.println(name + " has finished.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}
