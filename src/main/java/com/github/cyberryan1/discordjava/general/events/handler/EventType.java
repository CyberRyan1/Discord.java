package com.github.cyberryan1.discordjava.general.events.handler;

import com.github.cyberryan1.discordjava.general.events.ReadyEvent;

public enum EventType {

    ON_READY ( "READY", ReadyEvent.class ),
    ON_GUILD_CREATE ( "GUILD_CREATE", null ), // ! temporarily null
    ON_PRESECE_UPDATE ( "PRESENCE_UPDATE", null ); // ! temporarily null

    public final String value;
    public final Class<?> classValue;
    EventType( String val, Class<?> classVal ) {
        value = val;
        classValue = classVal;
    }
}