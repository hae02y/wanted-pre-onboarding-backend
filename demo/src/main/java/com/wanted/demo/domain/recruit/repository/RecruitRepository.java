package com.wanted.demo.domain.recruit.repository;

import com.wanted.demo.domain.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRepository extends JpaRepository<Recruit,Long> {
}
