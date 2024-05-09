package com.mundo.etl.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Author: 赖传剑
 * Version: 1.0
 * Date: 2018-01-02
 */
public class FirstTest {

    private volatile static int count = 0;

    private volatile static AtomicInteger number1 = new AtomicInteger(0);

//    @Test
    public void testTraversal() {
        HashMap<Integer, String> map = new HashMap<>(16);
        map.put(7, "");
        map.put(11, "");
        map.put(43, "");
        map.put(59, "");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");

        System.out.println("遍历结果：");
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> ");
        }

        System.out.println();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
        }

    }

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(3);
        // 构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 3, 1, TimeUnit.HOURS, queue,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        ThreadSuite threadSuite = new ThreadSuite();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            threadPool.execute(threadSuite);
            countDownLatch.countDown();
        }

        countDownLatch.await();
        threadPool.shutdown();
        System.out.println(count);
        System.out.println(number1);
    }

    static class ThreadSuite implements Runnable {

        @Override
        public void run() {
            addCount();
        }

        public synchronized void addCount() {
            count = count + 1;
            number1.getAndIncrement();
        }
    }

}
