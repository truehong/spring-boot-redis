package com.hong.redisApplication.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class LogWriter {
    @Autowired
    RedisTemplate<?, ?> redisTemplate;

    private static final String KEY_WAS_LOG = "was:log";
    private LocalDateTime date = LocalDateTime.now();

    /*
    * 레디스에 로그를 기록하기 위한 Logger의 생성자
    * */


    public Integer log(String log){
        ValueOperations<String, Object> vop = (ValueOperations<String, Object>) redisTemplate.opsForValue();
        Integer rtn = vop.append(KEY_WAS_LOG, date + log + "\n");
        System.out.println("LogWriter.log called" + rtn);
        return rtn;
    }


}
