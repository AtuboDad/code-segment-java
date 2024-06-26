package com.mundo.netty.demo.services;

public interface RedisService {

    void sort();
    void batchSet();

    boolean setnx(String key, String val);

    Long delnx(String key, String val);

}
