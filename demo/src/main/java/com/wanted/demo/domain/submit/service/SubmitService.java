package com.wanted.demo.domain.submit.service;

import com.wanted.demo.domain.member.entity.Member;
import com.wanted.demo.domain.member.repository.MemberRepository;
import com.wanted.demo.domain.recruit.entity.Recruit;
import com.wanted.demo.domain.recruit.repository.RecruitRepository;
import com.wanted.demo.domain.submit.dto.SubmitDto;
import com.wanted.demo.domain.submit.entity.Submit;
import com.wanted.demo.domain.submit.repository.SubmitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmitService {

    private final SubmitRepository submitRepository;
    private final MemberRepository memberRepository;
    private final RecruitRepository recruitRepository;

    public void submitApply(SubmitDto submitDto) {

        Member member = memberRepository.findById(submitDto.getMemberId()).orElseThrow();

        Recruit recruit = recruitRepository.findById(submitDto.getRecruitId()).orElseThrow();

        Submit submit = new Submit();

        submit.setMember(member);
        submit.setRecruit(recruit);

        findExistSubmit(member, recruit);

        submitRepository.save(submit);
    }

    public void findExistSubmit(Member member, Recruit recruit){

        if(submitRepository.existsSubmitByMemberAndRecruit(member, recruit)){
            throw new RuntimeException("hi");
        }
    }
}
