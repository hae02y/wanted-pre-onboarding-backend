package com.wanted.demo.domain.recruit.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class RecruitDetailDto {

    private Long recruitId;

    private String companyName;

    private String nation;

    private String region;

    private String position;

    private Long bonus;

    private String technique;

    private String detail;

    private List<Long> otherRecruitIds;

}
