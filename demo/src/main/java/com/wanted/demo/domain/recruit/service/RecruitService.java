package com.wanted.demo.domain.recruit.service;

import com.wanted.demo.domain.company.entity.Company;
import com.wanted.demo.domain.company.repository.CompanyRepository;
import com.wanted.demo.domain.recruit.entity.Recruit;
import com.wanted.demo.domain.recruit.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final CompanyRepository companyRepository;

    public void createRecruit(Recruit recruit, Long companyId) {

        Company findedCompany = companyRepository.findById(companyId).orElseThrow();

        recruit.setCompany(findedCompany);
        recruitRepository.save(recruit);
    }

    @Transactional
    public void patchRecruit(Recruit recruit) {
        Recruit findedRecruit = recruitRepository.findById(recruit.getRecruitId()).orElseThrow();

        recruitRepository.changeAll(recruit.getPosition(),recruit.getBonus(), recruit.getDetail(), recruit.getTechnique(),recruit.getRecruitId());
    }
}
