package io.freddie.hateaosstudy.controller;

import io.freddie.hateaosstudy.dto.CompanyDto;
import io.freddie.hateaosstudy.model.Company;
import io.freddie.hateaosstudy.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
    public ResponseEntity<EntityModel<CompanyDto>> getById(@PathVariable long id) {
        EntityModel<CompanyDto> companyDtoEntityModel = companyRepository.findById(id)
                .map(company -> new CompanyDto(company.getId(), company.getName(), company.getEstablishedAt()))
                .map(EntityModel::of)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        return ResponseEntity.ok()
                .eTag(Integer.toString(companyDtoEntityModel.getContent().hashCode()))
                .body(companyDtoEntityModel);
    }
}
