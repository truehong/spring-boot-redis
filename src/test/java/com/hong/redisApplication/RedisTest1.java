package com.hong.redisApplication;

import com.hong.redisApplication.Member.entities.Member;
import com.hong.redisApplication.Member.repositories.MemberRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest1 {
    @Autowired
    private MemberRepository memberRepository;

    @After
    public void tearDown() throws Exception{
        memberRepository.deleteAll();
    }
    @Test
    public void 기본_등록_조회기능(){
        // given
        Long id = 1L;
        LocalDateTime refreshTIme = LocalDateTime.of(2021,12,22,0,0);
        Member member = Member.builder().id(id)
                .name("sejin")
                .refreshTime(refreshTIme)
                .build();

        //when
        memberRepository.save(member);

        //then
        Member member1 = memberRepository.findById(id).get();
        assertThat(member.getName()).isEqualTo("sejin");
        assertThat(member.getRefreshTime()).isEqualTo(refreshTIme);
    }

    @Test
    public void 수정기능() {


    }
}
