package com.chen.cloud.comsumer.controller;

import com.chen.cloud.comsumer.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/consumer")
    public String helloConsumer() {
        String key = "test";
        String value = "hahaha";
        redisTemplate.opsForValue().set(key, value);
        System.out.println(redisTemplate.opsForValue().get(key));
        System.out.println(redisTemplate.randomKey());
        //System.out.println(redisTemplate.opsForValue().get(redisTemplate.randomKey()));
        return restTemplate.getForEntity("http://localhost:8071/hello", String.class).getBody();
    }
}
