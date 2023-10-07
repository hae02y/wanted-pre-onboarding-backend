package com.wanted.demo.domain.submit.entity;

import com.wanted.demo.domain.member.entity.Member;
import com.wanted.demo.domain.recruit.entity.Recruit;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Submit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submitId;

    @OneToOne
    private Recruit recruit;

    @ManyToOne
    private Member member;
}
