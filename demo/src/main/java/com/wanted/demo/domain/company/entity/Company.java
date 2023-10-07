package com.wanted.demo.domain.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String position;

    @Column
    private String bonus;

    @Column
    private String detail;

    @Column
    private String technique;
}
