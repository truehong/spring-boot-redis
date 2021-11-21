package com.hong.redisApplication.Member.controller;

import com.hong.redisApplication.Member.entities.Member;
import com.hong.redisApplication.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @PostMapping("/member")
    public ResponseEntity<Member> save(@RequestBody Member member) {
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findOne(@PathVariable Long id) {
        return new ResponseEntity<Member>(memberService.findOne(id),HttpStatus.OK);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> findAll(){
        return new ResponseEntity<List<Member>>(memberService.findAll(),HttpStatus.OK);
    }

}
