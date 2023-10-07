package com.wanted.demo.domain.recruit.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class RecruitResponseDto {

    private Long recruitId;

    private String companyName;

    private String nation;

    private String region;

    private String position;

    private Long bonus;

    private String technique;
}
