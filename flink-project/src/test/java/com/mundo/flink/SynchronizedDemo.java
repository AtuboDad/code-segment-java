package com.mundo.flink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedDemo implements Runnable {
    public void test() {
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(synchronizedDemo);
            thread.start();

            threadList.add(thread);
        }

//        for (Thread thread : threadList) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        System.out.println(count);
//        System.out.println(countNum2.get());
    }

    public static volatile int count = 0;
    public static volatile AtomicInteger countNum2 = new AtomicInteger(0);

    public synchronized static void addCount() {
        count++;
//        countNum2.getAndIncrement();
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {

        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        synchronizedDemo.test();

    }
}

