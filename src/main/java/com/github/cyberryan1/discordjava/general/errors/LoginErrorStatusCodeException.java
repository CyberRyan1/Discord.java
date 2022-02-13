package com.github.cyberryan1.discordjava.general.errors;

import org.apache.commons.lang.exception.ExceptionUtils;

public class LoginErrorStatusCodeException extends RuntimeException {

    public LoginErrorStatusCodeException( String msg ) {
        super( msg );
    }

    public LoginErrorStatusCodeException( String msg, Throwable error ) {
        super( msg + ExceptionUtils.getFullStackTrace( error ) );
    }
}
