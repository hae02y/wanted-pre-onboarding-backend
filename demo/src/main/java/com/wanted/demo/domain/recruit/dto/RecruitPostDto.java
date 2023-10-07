package com.wanted.demo.domain.recruit.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class RecruitPostDto {

        private Long companyId;

        private String position;

        private Long bonus;

        private String detail;

        private String technique;

}
