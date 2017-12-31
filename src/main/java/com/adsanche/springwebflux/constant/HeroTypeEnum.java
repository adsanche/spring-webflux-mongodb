package com.adsanche.springwebflux.constant;

/**
 * Created by adsanche on 21/06/17.
 */
public enum HeroTypeEnum {

    SUPERHERO(1, "Super Hero"),
    VILLAIN(2, "Villain");

    private final int id;
    private final String label;

    HeroTypeEnum(final int id, final String label) {

        this.id = id;
        this.label = label;
    }
}
