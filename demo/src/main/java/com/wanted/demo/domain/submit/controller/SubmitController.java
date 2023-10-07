package com.wanted.demo.domain.submit.controller;

import com.wanted.demo.domain.submit.dto.SubmitDto;
import com.wanted.demo.domain.submit.service.SubmitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/submit")
@RequiredArgsConstructor
public class SubmitController {

    private final SubmitService submitService;

    @PostMapping
    public ResponseEntity<?> postSubmit(@RequestBody SubmitDto submitDto){

        submitService.submitApply(submitDto);

        return new ResponseEntity<>("정상적으로 지원 되었어요",HttpStatus.CREATED);
    }
}
