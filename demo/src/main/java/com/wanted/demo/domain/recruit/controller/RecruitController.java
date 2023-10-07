package com.wanted.demo.domain.recruit.controller;

import com.wanted.demo.domain.recruit.dto.RecruitDetailDto;
import com.wanted.demo.domain.recruit.dto.RecruitPatchDto;
import com.wanted.demo.domain.recruit.dto.RecruitPostDto;
import com.wanted.demo.domain.recruit.dto.RecruitResponseDto;
import com.wanted.demo.domain.recruit.entity.Recruit;
import com.wanted.demo.domain.recruit.mapper.RecruitMapper;
import com.wanted.demo.domain.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruit")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitMapper recruitMapper;
    private final RecruitService recruitService;

    @PostMapping("/create")
    public ResponseEntity<?> postRecruit(@RequestBody RecruitPostDto recruitPostDto){

        Recruit recruit = recruitMapper.recruitPostDtoToRecruit(recruitPostDto);
        recruitService.createRecruit(recruit, recruitPostDto.getCompanyId());

        return new ResponseEntity<>("정상적으로 저장됨",HttpStatus.CREATED);
    }

    @PatchMapping("/update/{recruit-id}")
    public ResponseEntity<?> patchRecruit(@PathVariable("recruit-id") Long recruitId,
            @RequestBody RecruitPatchDto recruitPatchDto){

        Recruit recruit = recruitMapper.recruitPatchDtoToRecruit(recruitPatchDto);
        recruit.setRecruitId(recruitId);
        recruitService.patchRecruit(recruit);

        return new ResponseEntity<>("정상적으로 변경됨",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{recruit-id}")
    public ResponseEntity<?> deleteRecruit(@PathVariable("recruit-id") Long recruitId){

        recruitService.deleteRecruit(recruitId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/find/all")
    public ResponseEntity<?> getRecruit(){

        List<Recruit> recruitList = recruitService.findAllRecruit();

        List<RecruitResponseDto> recruitResponseDtos = recruitMapper.recruitListToRecruitResponseDtos(recruitList);

        return new ResponseEntity<>(recruitResponseDtos,HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<?> getSearchRecruit(@RequestParam("search") String search){

        List<Recruit> recruitList = recruitService.findSearchRecruit(search);

        List<RecruitResponseDto> recruitResponseDtos = recruitMapper.recruitListToRecruitResponseDtos(recruitList);

        return new ResponseEntity<>(recruitResponseDtos,HttpStatus.OK);
    }

    @GetMapping("/find/detail/{recruit-id}")
    public ResponseEntity<?> getDetailRecruit(@PathVariable("recruit-id") Long recruitId){

        RecruitDetailDto detailRecruit = recruitService.findDetailRecruit(recruitId);

        return new ResponseEntity<>(detailRecruit,HttpStatus.OK);
    }
}
