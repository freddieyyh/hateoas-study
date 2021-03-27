package io.freddie.hateaosstudy.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CompanyDto {
    private final long id;
    private final String name;
    private final LocalDate establishedAt;
}
