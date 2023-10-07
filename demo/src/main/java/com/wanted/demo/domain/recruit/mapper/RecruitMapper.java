package com.wanted.demo.domain.recruit.mapper;

import com.wanted.demo.domain.recruit.dto.RecruitPatchDto;
import com.wanted.demo.domain.recruit.dto.RecruitPostDto;
import com.wanted.demo.domain.recruit.entity.Recruit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecruitMapper {

    Recruit recruitPostDtoToRecruit(RecruitPostDto recruitPostDto);
    Recruit recruitPatchDtoToRecruit(RecruitPatchDto recruitPatchDto);

}
