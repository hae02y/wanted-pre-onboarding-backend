package com.wanted.demo.domain.recruit.service;

import com.wanted.demo.domain.company.entity.Company;
import com.wanted.demo.domain.company.repository.CompanyRepository;
import com.wanted.demo.domain.recruit.dto.RecruitDetailDto;
import com.wanted.demo.domain.recruit.entity.Recruit;
import com.wanted.demo.domain.recruit.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public void deleteRecruit(Long recruitId) {

        recruitRepository.deleteById(recruitId);
    }

    public List<Recruit> findAllRecruit() {

        return recruitRepository.findAll();
    }

    public List<Recruit> findSearchRecruit(String search) {

        return recruitRepository.findRecruitsBySearchString(search);
    }

    public RecruitDetailDto findDetailRecruit(Long recruitId) {
        Recruit findedRecruit = recruitRepository.findById(recruitId).orElseThrow();

        Company company = findedRecruit.getCompany();
        List<Long> idsByCompany = recruitRepository.findIdsByCompany(company);

        return RecruitDetailDto.builder()
                .detail(findedRecruit.getDetail())
                .bonus(findedRecruit.getBonus())
                .nation(company.getNation())
                .region(company.getRegion())
                .technique(findedRecruit.getTechnique())
                .companyName(company.getName())
                .position(findedRecruit.getPosition())
                .recruitId(findedRecruit.getRecruitId())
                .otherRecruitIds(idsByCompany)
                .build();
    }

}
