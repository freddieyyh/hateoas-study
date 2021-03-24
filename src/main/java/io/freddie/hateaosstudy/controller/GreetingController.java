package io.freddie.hateaosstudy.controller;

import io.freddie.hateaosstudy.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public Greeting get(@RequestParam(defaultValue = "defaultValue") String content) {
        Greeting greeting = new Greeting(content);

        greeting.add(linkTo(methodOn(GreetingController.class).get(content)).withSelfRel());

        return greeting;
    }
}
