package com.github.cyberryan1.discordjava.general.errors;

import org.apache.commons.lang.exception.ExceptionUtils;

public class LoginRequestException extends RuntimeException {

    public LoginRequestException( Throwable error ) {
        super( "An error occurred processing the request/response for connection to discord API: "
                + ExceptionUtils.getFullStackTrace( error ) );
    }
}
