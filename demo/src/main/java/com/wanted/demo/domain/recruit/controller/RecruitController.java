package com.wanted.demo.domain.recruit.controller;

import com.wanted.demo.domain.recruit.dto.RecruitPostDto;
import com.wanted.demo.domain.recruit.entity.Recruit;
import com.wanted.demo.domain.recruit.mapper.RecruitMapper;
import com.wanted.demo.domain.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruit")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitMapper recruitMapper;
    private final RecruitService recruitService;

    @PostMapping("/create")
    public ResponseEntity<?> postRecruit(@RequestBody RecruitPostDto recruitPostDto){

        Recruit recruit = recruitMapper.recruitPostDtoToRecruit(recruitPostDto);
        Recruit recruited = recruitService.createRecruit(recruit, recruitPostDto.getCompanyId());

        RecruitPostDto response = recruitMapper.recruitToRecruitDto(recruited);

        return new ResponseEntity<>("정상적으로 저장됨",HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> patchRecruit(){

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRecruit(){

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getRecruit(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hi")
    public ResponseEntity<?> getSearchRecruit(@RequestParam("search") String search){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
