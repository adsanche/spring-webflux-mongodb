package com.adsanche.springwebflux.controller;

import com.adsanche.springwebflux.entity.Hero;
import com.adsanche.springwebflux.service.IHeroService;
import com.adsanche.springwebflux.util.BadParametersException;
import com.adsanche.springwebflux.util.HeroNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by adsanche on 20/06/17.
 */
@Api(value = "/heroes", description = "Service managing operations linked to the heroes")
@RestController
public class HeroController {

    @Autowired
    private IHeroService heroService;

    @ApiOperation(value = "Get all the heroes", response = Hero.class, responseContainer = "List")
    @GetMapping(value = "/heroes")
    public Flux<Hero> getAllHeroes() {

        return this.heroService.getAllHeroes();
    }

    @ApiOperation(value = "Get a hero by his ID", response = Hero.class)
    @GetMapping("/heroes/{id}")
    public Mono<Hero> getHeroById(@PathVariable final String id)
            throws BadParametersException, HeroNotFoundException {

        return this.heroService.getHeroById(id);
    }

    @ApiOperation(value = "Get a hero by his name", response = Hero.class)
    @GetMapping(value = "/heroes", params = "heroname")
    public Mono<Hero> getHeroByHeroName(@RequestParam(value = "heroname") final String heroName)
            throws BadParametersException, HeroNotFoundException {

        return this.heroService.getHeroByHeroName(heroName);
    }
}
