package com.hong.redisApplication.Member.entities;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@RedisHash("Member")
@Builder
public class Member implements Serializable{
    @Id @org.springframework.data.annotation.Id
    private Long id;
    private String name;
    private String desc;
    private LocalDateTime refreshTime;

    public void refresh(String desc, LocalDateTime refreshTime) {
        if(refreshTime.isAfter(this.refreshTime)){
            this.desc = desc;
            this.refreshTime = refreshTime;
        }
    }

}
