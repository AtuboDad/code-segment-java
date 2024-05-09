package com.mundo.flink.java;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

public class UserDemo {


//    com.mundo.flink.java.User object internals:
//    OFFSET  SIZE                TYPE DESCRIPTION                               VALUE
//      0     4                     (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//      4     4                     (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//      8     4                     (object header)                           43 c1 00 f8 (01000011 11000001 00000000 11111000) (-134168253)
//     12     1             boolean User.sex                                  false
//     13     3                     (alignment/padding gap)
//     16     4    java.lang.String User.name                                 null
//     20     4   java.lang.Integer User.age                                  null
//    Instance size: 24 bytes

    public static void main(String[] args) {
        List<User> data = new ArrayList<>();
        User user = new User();
        User user2 = new User();
        data.add(user);
        user2.setSex(true);
        data.add(user2);
        System.out.println(ClassLayout.parseInstance(data).toPrintable());
        System.out.println("===============");
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println("===============");
        synchronized (user2) {
            System.out.println(ClassLayout.parseInstance(user2).toPrintable());
        }
        System.out.println("===============");
        Thread userThread = new Thread(new UserThread());
        userThread.start();
    }

}

class UserThread implements Runnable {

    @Override
    public void run() {
        System.out.println("===============thread=start");
        User user = new User();
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
        System.out.println("===============thread=end");
    }

}
