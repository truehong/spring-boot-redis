package com.hong.redisApplication;

import com.hong.redisApplication.log.LogWriter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Random;

public class RedisWriterTest {
    @Autowired
    static LogWriter logger;

    @Test
    public void testLogger() {
        for (int i =0; i<100; i++) {
            Assertions.assertTrue(logger.log("This is a test message 1") > 0);
            try {
                Thread.sleep(new Random().nextInt());
            }catch (InterruptedException e) {
                // do nothing
            }
        }
    }

    @Autowired
    RedisTemplate<?, ?> redisTemplate;

    @Test
    public void test() {
        //get/set을 위한 객체
        ValueOperations<String, Object> vop = (ValueOperations<String, Object>) redisTemplate.opsForValue();
        vop.set("jdkSerial", "jdk");
        String result = (String) vop.get("jdkSerial");
        System.out.println(result);//jdk
    }

}
