package io.freddie.hateaosstudy;

import io.freddie.hateaosstudy.model.Company;
import io.freddie.hateaosstudy.repository.CompanyRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class HateaosStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HateaosStudyApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(CompanyRepository companyRepository) {
        return args -> {
            List<Company> companies = List.of(new Company(0L, "NAVER", LocalDate.now(), Collections.emptyList()),
                    new Company(0L, "KAKAO", LocalDate.of(2006, 3, 12), Collections.emptyList()));

            companyRepository.saveAll(companies);
        };
    }
}
