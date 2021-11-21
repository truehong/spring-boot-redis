package com.hong.redisApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    void test(){
        final String key = "testString";
        final ValueOperations<String,String> stringValueOperation = redisTemplate.opsForValue();
        stringValueOperation.set(key, "1");
        final String result_1 =
                stringValueOperation.get(key);

        System.out.println("result_1 = " + result_1);
    }

    @Test
    public void testOfList() {
        final String key = "list";
        final ListOperations<String, String> listOperations = redisTemplate.opsForList();

        listOperations.rightPush(key, "H");
        listOperations.rightPush(key, "E");
        listOperations.rightPush(key, "L");
        listOperations.rightPush(key, "L");
        listOperations.rightPush(key, "O");

        listOperations.rightPushAll(key, " ", "W", "O", "L", "D");

        final String character_1 = listOperations.index(key, 1);
        System.out.println("character_1" + character_1);

        final Long size = listOperations.size(key);
        System.out.println("size = " + size );

        final List<String> resultRange = listOperations.range(key, 0, 9);
        print(resultRange);


    }
    void print (Object obj){
        System.out.println(obj.getClass() + ": " +obj.toString());
    }
}
