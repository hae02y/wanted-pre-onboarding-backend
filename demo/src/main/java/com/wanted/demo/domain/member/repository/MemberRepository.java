package com.wanted.demo.domain.member.repository;

import com.wanted.demo.domain.member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
