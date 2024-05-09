package com.mundo.etl.test;

import org.junit.Test;

public class BubbleSortSuite {
    public static void main(String[] args) {

        int unSortedArr[] = new int[]{10, 1, 5, 3, 9};

        for (int i = 0; i < unSortedArr.length; i++) {
            for (int j = 0; j < unSortedArr.length - 1 - i; j++) {
                if (unSortedArr[j + 1] < unSortedArr[j]) {
                    int temp = unSortedArr[j + 1];
                    unSortedArr[j + 1] = unSortedArr[j];
                    unSortedArr[j] = temp;
                }
                printlnArr(unSortedArr);
            }
        }

        printlnArr(unSortedArr);
    }

    private static void printlnArr(int[] unSortedArr) {
        for (int value : unSortedArr) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }

    @Test
    public void testMethod() {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.print(n1 == n2);
        System.out.print(",");
        System.out.println(n1 != n2);
//        mystery(1234);
    }

    public static void mystery(int x) {
        System.out.print(x % 10);

        if ((x / 10) != 0) {
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }
}
