package com.wanted.demo.domain.submit.repository;

import com.wanted.demo.domain.member.entity.Member;
import com.wanted.demo.domain.recruit.entity.Recruit;
import com.wanted.demo.domain.submit.entity.Submit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmitRepository extends JpaRepository<Submit,Long> {

    boolean existsSubmitByMemberAndRecruit(Member member, Recruit recruit);
}
