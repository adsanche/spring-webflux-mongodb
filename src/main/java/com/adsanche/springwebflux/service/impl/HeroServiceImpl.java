package com.adsanche.springwebflux.service.impl;

import com.adsanche.springwebflux.entity.Hero;
import com.adsanche.springwebflux.repository.IHeroRepository;
import com.adsanche.springwebflux.service.IHeroService;
import com.adsanche.springwebflux.util.BadParametersException;
import com.adsanche.springwebflux.util.HeroNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by adsanche on 21/06/17.
 */
@Service
public class HeroServiceImpl implements IHeroService {

    @Autowired
    private IHeroRepository heroRepository;

    @Override
    public Flux<Hero> getAllHeroes() {

        return this.heroRepository.findAll();
    }

    @Override
    public Mono<Hero> getHeroById(final String id) throws BadParametersException, HeroNotFoundException {

        if (StringUtils.isEmpty(id)) {
            throw new BadParametersException("Hero ID cannot be empty");
        }

        return this.heroRepository.findById(id);
    }

    @Override
    public Mono<Hero> getHeroByHeroName(final String heroName) throws BadParametersException, HeroNotFoundException {

        if (StringUtils.isEmpty(heroName)) {
            throw new BadParametersException("Hero name cannot be empty");
        }

        return this.heroRepository.findByHeroName(heroName);
    }
}
