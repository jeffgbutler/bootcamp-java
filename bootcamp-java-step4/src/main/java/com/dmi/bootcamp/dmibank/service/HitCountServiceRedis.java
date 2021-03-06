package com.dmi.bootcamp.dmibank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class HitCountServiceRedis implements HitCountService {

    private static final String REDIS_KEY = "payment-calculator";

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;
    
    @Override
    public long incrementHitCount() {
        return redisTemplate.opsForValue().increment(REDIS_KEY, 1);
    }

    @Override
    public void resetHitCount() {
        redisTemplate.opsForValue().set(REDIS_KEY, 0);
    }
}
