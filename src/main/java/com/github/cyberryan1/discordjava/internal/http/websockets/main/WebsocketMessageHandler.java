package com.github.cyberryan1.discordjava.internal.http.websockets.main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME )
public @interface WebsocketMessageHandler {
    OpCode value();
}