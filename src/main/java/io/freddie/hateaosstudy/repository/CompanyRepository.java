package io.freddie.hateaosstudy.repository;

import io.freddie.hateaosstudy.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
