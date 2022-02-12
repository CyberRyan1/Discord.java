package com.github.cyberryan1.discordjava.internal.classes;

import com.github.cyberryan1.discordjava.general.events.handler.EventType;

public class EventData {

    private transient String dataString;
    private String t; // type of the event
    private int s; // operation number of the session
    private int op; // opcode

    public void setDataString( String dataString ) { this.dataString = dataString; }

    public String getDataString() { return dataString; }

    public String getStringType() { return t; }

    public EventType getEventType() {
        for ( EventType event : EventType.values() ) {
            if ( event.value.equals( t ) ) {
                return event;
            }
        }
        return null;
    }

    public int getOpCode() { return op; }
}