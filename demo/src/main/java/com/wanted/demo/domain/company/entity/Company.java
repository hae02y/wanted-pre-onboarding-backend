package com.wanted.demo.domain.company.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String nation;

    @Column
    private String region;
}
