package com.wanted.demo.domain.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String age;
}
