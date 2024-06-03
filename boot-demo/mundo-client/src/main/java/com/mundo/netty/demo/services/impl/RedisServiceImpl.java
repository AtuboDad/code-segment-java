package com.mundo.netty.demo.services.impl;

import com.mundo.netty.demo.services.RedisService;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;

    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";


    @Override
    public void sort() {
        Object testValue = redisTemplate.opsForValue().get("test_key1");


        String lockKey = "123";
        String UUID = cn.hutool.core.lang.UUID.fastUUID().toString();
        boolean success = redisTemplate.opsForValue().setIfAbsent(lockKey,UUID,3, TimeUnit.MINUTES);
        if (!success){
            System.out.println("锁已存在");
        }
        // 指定 lua 脚本，并且指定返回值类型
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        Long result = (Long) redisTemplate.execute(redisScript, Collections.singletonList(lockKey),UUID);
        System.out.println(result);

    }

    @Override
    public void batchSet() {
        redisTemplate.executePipelined((RedisCallback<Object>) redisConnection -> {

            for (int i = 0; i < 100; i++) {

            }
            return null;
        });
    }

    @Override
    public boolean setnx(String key, String val) {
        return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(key, val, 3, TimeUnit.MINUTES));
    }

    @Override
    public Long delnx(String key, String val) {
        // 指定 lua 脚本，并且指定返回值类型
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        return (Long) redisTemplate.execute(redisScript, Collections.singletonList(key), val);
    }

}
