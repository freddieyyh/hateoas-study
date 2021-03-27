package io.freddie.hateaosstudy.controller;

import io.freddie.hateaosstudy.dto.CompanyDto;
import io.freddie.hateaosstudy.model.Company;
import io.freddie.hateaosstudy.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;

    @GetMapping
    public CollectionModel<Company> get() {
        return CollectionModel.of(companyRepository.findAll());
    }

    @GetMapping("/{id}")
    public EntityModel<CompanyDto> getById(@PathVariable long id) {
        return companyRepository.findById(id)
                .map(company -> new CompanyDto(company.getId(), company.getName(), company.getEstablishedAt()))
                .map(companyDto -> {
                    return EntityModel.of(companyDto)
                            .add(linkTo(methodOn(CompanyController.class).getById(id)).withSelfRel());
                })
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }
}
