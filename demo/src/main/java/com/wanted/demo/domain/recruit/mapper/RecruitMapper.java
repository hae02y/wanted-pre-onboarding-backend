package com.wanted.demo.domain.recruit.mapper;

import com.wanted.demo.domain.company.entity.Company;
import com.wanted.demo.domain.recruit.dto.RecruitPatchDto;
import com.wanted.demo.domain.recruit.dto.RecruitPostDto;
import com.wanted.demo.domain.recruit.dto.RecruitResponseDto;
import com.wanted.demo.domain.recruit.entity.Recruit;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RecruitMapper {


    default List<RecruitResponseDto> recruitListToRecruitResponseDtos(List<Recruit> recruitList){
        List<RecruitResponseDto> recruitResponseDtos = new ArrayList<>();

        for(Recruit recruit : recruitList){

            Company company = recruit.getCompany();

            RecruitResponseDto recruitResponseDto = RecruitResponseDto.builder()
                    .recruitId(recruit.getRecruitId())
                    .region(company.getRegion())
                    .bonus(recruit.getBonus())
                    .nation(company.getNation())
                    .companyName(company.getName())
                    .position(recruit.getPosition())
                    .technique(recruit.getTechnique())
                    .build();

            recruitResponseDtos.add(recruitResponseDto);
        }

        return recruitResponseDtos;
    }

    Recruit recruitPostDtoToRecruit(RecruitPostDto recruitPostDto);
    Recruit recruitPatchDtoToRecruit(RecruitPatchDto recruitPatchDto);

}
