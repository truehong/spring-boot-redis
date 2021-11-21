package com.hong.redisApplication.Member.repositories;

import com.hong.redisApplication.Member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
