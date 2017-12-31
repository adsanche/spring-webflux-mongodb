package com.adsanche.springwebflux.entity;

import com.adsanche.springwebflux.constant.HeroTypeEnum;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by adsanche on 21/06/17.
 */
@Data
@Builder
public class Hero {

    @Id
    private String id;

    private String heroName;

    private String city;

    private Person identity;

    private HeroTypeEnum type;
}
