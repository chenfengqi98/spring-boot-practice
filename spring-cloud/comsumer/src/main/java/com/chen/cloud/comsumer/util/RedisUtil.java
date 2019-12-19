package com.chen.cloud.comsumer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RedisUtil {

    @Autowired
    private static RedisTemplate<String,String> redisTemplate;

    public static final long DEFAULT_EXPIRE = 60 * 60 * 24;
    public static final long NOT_EXPIRE = -1;

    public boolean containsKey(String key){
        return redisTemplate.hasKey(key);
    }

    public static void renameKey(String oldKey, String newKey){
        redisTemplate.rename(oldKey,newKey);
    }

    public static boolean renameKeyNotExist(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    public static void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    public static void deleteKey(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    public static void expireKey(String key, long time, TimeUnit timeUnit){
        redisTemplate.expire(key,time,timeUnit);
    }

    public static void expireKeyAt(String key, Date date){
        redisTemplate.expireAt(key,date);
    }

    public static long getKeyExpire(String key, TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

    public void persistKey(String key){
        redisTemplate.persist(key);
    }
}
