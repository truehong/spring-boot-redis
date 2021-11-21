package com.hong.redisApplication.Member.service;

import com.hong.redisApplication.Member.entities.Member;

import java.util.List;

public interface MemberService {
    Member save(Member member);

    Member findOne(Long id);

     List<Member> findAll();


}
