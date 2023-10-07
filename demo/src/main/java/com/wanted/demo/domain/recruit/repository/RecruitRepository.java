package com.wanted.demo.domain.recruit.repository;

import com.wanted.demo.domain.company.entity.Company;
import com.wanted.demo.domain.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecruitRepository extends JpaRepository<Recruit,Long> {

    @Transactional
    @Modifying
    @Query(value = "update Recruit r set r.position = :position, r.bonus = :bonus, r.detail = :detail, r.technique = :technique where r.recruitId = :id", nativeQuery = false)
    int changeAll(@Param("position") String position,
                          @Param("bonus") Long bonus,
                          @Param("detail") String detail,
                          @Param("technique") String technique,
                          @Param("id") Long id);

    @Query("SELECT r FROM Recruit r WHERE " +
            "r.position LIKE %:search% OR " +
            "CAST(r.bonus AS string) LIKE %:search% OR " +
            "r.technique LIKE %:search% OR " +
            "r.company.name LIKE %:search% OR " +
            "r.company.nation LIKE %:search% OR " +
            "r.company.region LIKE %:search% ")
    List<Recruit> findRecruitsBySearchString(@Param("search") String search);

    @Query(value = "select r.recruitId from  Recruit r where r.company = :company")
    List<Long> findIdsByCompany(Company company);
}
