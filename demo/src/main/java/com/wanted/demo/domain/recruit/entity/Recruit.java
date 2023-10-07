package com.wanted.demo.domain.recruit.entity;

import com.wanted.demo.domain.company.entity.Company;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Recruit {

    public Recruit(String position, Long bonus, String detail, String technique) {
        this.position = position;
        this.bonus = bonus;
        this.detail = detail;
        this.technique = technique;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;

    @Column
    private String position;

    @Column
    private Long bonus;

    @Column
    private String detail;

    @Column
    private String technique;

    @ManyToOne
    private Company company;

}
