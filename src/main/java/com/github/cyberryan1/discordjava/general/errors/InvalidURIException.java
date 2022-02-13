package com.github.cyberryan1.discordjava.general.errors;

import org.apache.commons.lang.exception.ExceptionUtils;

public class InvalidURIException extends RuntimeException {

    public InvalidURIException( String URILink, Throwable error ) {
        super( "Invalid URI link \"" + URILink + "\" provided: " + ExceptionUtils.getFullStackTrace( error ) );
    }
}