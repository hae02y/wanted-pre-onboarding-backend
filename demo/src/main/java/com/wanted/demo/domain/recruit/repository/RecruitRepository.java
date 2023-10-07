package com.wanted.demo.domain.recruit.repository;

import com.wanted.demo.domain.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RecruitRepository extends JpaRepository<Recruit,Long> {

    @Transactional
    @Modifying
    @Query(value = "update Recruit r set r.position = :position, r.bonus = :bonus, r.detail = :detail, r.technique = :technique where r.recruitId = :id", nativeQuery = false)
    public int changeAll(@Param("position") String position,
                          @Param("bonus") Long bonus,
                          @Param("detail") String detail,
                          @Param("technique") String technique,
                          @Param("id") Long id);
}
