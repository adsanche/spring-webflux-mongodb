package com.adsanche.springwebflux;

import com.adsanche.springwebflux.constant.GenderEnum;
import com.adsanche.springwebflux.constant.HeroTypeEnum;
import com.adsanche.springwebflux.entity.Hero;
import com.adsanche.springwebflux.entity.Person;
import com.adsanche.springwebflux.repository.IHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private IHeroRepository heroRepository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        this.heroRepository.deleteAll().subscribe();

        final Flux<Hero> heroesFlux = Flux.just(
                Hero.builder().heroName("Batman")
                        .city("Gotham City")
                        .identity(Person.builder().gender(GenderEnum.MR)
                                .firstName("Bruce")
                                .lastName("Wayne")
                                .age(37).build())
                        .type(HeroTypeEnum.SUPERHERO).build(),
                Hero.builder().heroName("Harley Queen")
                        .city("Gotham City")
                        .identity(Person.builder().gender(GenderEnum.MRS)
                                .firstName("Harleen")
                                .lastName("Quinzel")
                                .age(32).build())
                        .type(HeroTypeEnum.VILLAIN).build(),
                Hero.builder().heroName("Robin")
                        .city("Gotham City")
                        .identity(Person.builder().gender(GenderEnum.MR)
                                .firstName("Damian")
                                .lastName("Wayne")
                                .age(22).build())
                        .type(HeroTypeEnum.SUPERHERO).build(),
                Hero.builder().heroName("Superman")
                        .city("Metropolis")
                        .identity(Person.builder().gender(GenderEnum.MR)
                                .firstName("Clark")
                                .lastName("Kent")
                                .age(32).build())
                        .type(HeroTypeEnum.SUPERHERO).build(),
                Hero.builder().heroName("Wonder Woman")
                        .city("Themyscira")
                        .identity(Person.builder().gender(GenderEnum.MRS)
                                .firstName("Diana")
                                .lastName("Prince")
                                .age(30).build())
                        .type(HeroTypeEnum.SUPERHERO).build(),
                Hero.builder().heroName("Mr. Freeze")
                        .city("Gotham City")
                        .identity(Person.builder().gender(GenderEnum.MR)
                                .firstName("Victor")
                                .lastName("Fries")
                                .age(40).build())
                        .type(HeroTypeEnum.VILLAIN).build(),
                Hero.builder().heroName("Black Adam")
                        .city("Kahndaq")
                        .identity(Person.builder().gender(GenderEnum.MR)
                                .firstName("Theo")
                                .lastName("Adam")
                                .age(37).build())
                        .type(HeroTypeEnum.VILLAIN).build(),
                Hero.builder().heroName("Flash")
                        .city("Central City")
                        .identity(Person.builder().gender(GenderEnum.MR)
                                .firstName("Barry")
                                .lastName("Allen")
                                .age(28).build())
                        .type(HeroTypeEnum.SUPERHERO).build());

        this.heroRepository.saveAll(heroesFlux).subscribe();
    }
}
