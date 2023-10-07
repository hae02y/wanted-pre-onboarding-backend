package com.wanted.demo.domain.submit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Submit {
    @Id
    private Long submitId;
}
