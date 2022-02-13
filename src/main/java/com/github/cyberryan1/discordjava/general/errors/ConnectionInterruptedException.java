package com.github.cyberryan1.discordjava.general.errors;

import org.apache.commons.lang.exception.ExceptionUtils;

public class ConnectionInterruptedException extends RuntimeException {

    public ConnectionInterruptedException( Throwable error ) {
        super( "Interrupted before being able to successfully connect: " + ExceptionUtils.getFullStackTrace( error ) );
    }
}
