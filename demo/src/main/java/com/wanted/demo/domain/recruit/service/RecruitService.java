package com.wanted.demo.domain.recruit.service;

import com.wanted.demo.domain.company.entity.Company;
import com.wanted.demo.domain.company.repository.CompanyRepository;
import com.wanted.demo.domain.recruit.entity.Recruit;
import com.wanted.demo.domain.recruit.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final CompanyRepository companyRepository;

    public Recruit createRecruit(Recruit recruit, Long companyId) {

        Company findedCompany = companyRepository.findById(companyId).orElseThrow();

        recruit.setCompany(findedCompany);

        return recruitRepository.save(recruit);
    }
}
