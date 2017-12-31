package com.adsanche.springwebflux.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by adsanche on 23/06/17.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad input parameters")
public class BadParametersException extends Exception {

    public BadParametersException(final String message) {

        super(message);
    }
}
