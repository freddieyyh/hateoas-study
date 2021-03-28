package io.freddie.hateaosstudy.controller;

import io.freddie.hateaosstudy.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
@ExposesResourceFor(Team.class)
public class TeamController {
}
