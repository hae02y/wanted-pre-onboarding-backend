package com.wanted.demo.domain.member.repository;

import com.wanted.demo.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
