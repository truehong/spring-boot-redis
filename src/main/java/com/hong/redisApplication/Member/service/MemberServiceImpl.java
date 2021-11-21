package com.hong.redisApplication.Member.service;

import com.hong.redisApplication.Member.entities.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.hong.redisApplication.Member.repositories.MemberRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{
    MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    @Cacheable
    public Member findOne(Long id){
        return null;
       // return memberRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Member> findAll() {
     //   return memberRepository.findAll();
        return null;
    }

}
