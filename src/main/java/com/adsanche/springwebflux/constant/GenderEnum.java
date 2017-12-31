package com.adsanche.springwebflux.constant;

/**
 * Created by adsanche on 21/06/17.
 */
public enum GenderEnum {

    MR(1, "Mister"),
    MRS(2, "Miss");

    private final int id;
    private final String label;

    GenderEnum(final int id, final String label) {

        this.id = id;
        this.label = label;
    }
}
