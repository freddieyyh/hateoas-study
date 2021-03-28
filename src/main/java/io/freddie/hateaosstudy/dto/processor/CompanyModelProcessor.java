package io.freddie.hateaosstudy.dto.processor;

import io.freddie.hateaosstudy.controller.CompanyController;
import io.freddie.hateaosstudy.dto.CompanyDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CompanyModelProcessor implements RepresentationModelProcessor<EntityModel<CompanyDto>> {
    @Override
    public EntityModel<CompanyDto> process(EntityModel<CompanyDto> model) {
        CompanyDto company = model.getContent();
        model.add(linkTo(methodOn(CompanyController.class).getById(company.getId())).withSelfRel());
        return model;
    }
}
