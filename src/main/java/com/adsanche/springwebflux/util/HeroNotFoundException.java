package com.adsanche.springwebflux.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by adsanche on 23/06/17.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No hero found")
public class HeroNotFoundException extends Exception {

    public HeroNotFoundException(final String message) {

        super(message);
    }
}
