package com.adsanche.springwebflux.repository;

import com.adsanche.springwebflux.entity.Hero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Created by adsanche on 07/07/17.
 */
public interface IHeroRepository extends ReactiveMongoRepository<Hero, String> {

    Mono<Hero> findByHeroName(String heroName);
}
