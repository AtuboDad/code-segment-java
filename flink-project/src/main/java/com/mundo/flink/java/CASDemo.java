package com.mundo.flink.java;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示CAS compareAndSet 比较并交换
 */
public class CASDemo {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

}
