package com.wanted.demo.domain.company.repository;

import com.wanted.demo.domain.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
