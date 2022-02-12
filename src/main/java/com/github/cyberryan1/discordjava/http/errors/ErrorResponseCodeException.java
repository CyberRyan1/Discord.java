package com.github.cyberryan1.discordjava.http.errors;

public class ErrorResponseCodeException extends RuntimeException {

    public ErrorResponseCodeException( int errorCodeNumber ) {
        this( errorCodeNumber, null );
    }

    public ErrorResponseCodeException( int errorCodeNumber, Throwable cause ) {
        super( "Received an error response (" + errorCodeNumber + ") from the com.github.cyberryan1.discord API.", cause );
    }
}
