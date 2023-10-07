package com.wanted.demo.domain.recruit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recruit {

    @Id
    private Long id;

    @Column
    private String nation;

    @Column
    private String region;

}
