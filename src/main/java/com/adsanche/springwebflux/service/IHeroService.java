package com.adsanche.springwebflux.service;

import com.adsanche.springwebflux.entity.Hero;
import com.adsanche.springwebflux.util.BadParametersException;
import com.adsanche.springwebflux.util.HeroNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by adsanche on 21/06/17.
 */
public interface IHeroService {

    Flux<Hero> getAllHeroes();

    Mono<Hero> getHeroById(String id) throws BadParametersException, HeroNotFoundException;

    Mono<Hero> getHeroByHeroName(String heroName) throws BadParametersException, HeroNotFoundException;
}
