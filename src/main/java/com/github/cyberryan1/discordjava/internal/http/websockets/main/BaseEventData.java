package com.github.cyberryan1.discordjava.internal.http.websockets.main;

public class BaseEventData {

    private String t;
    private int s;
    private int op;

    public String getType() { return t; }
    public int getS() { return s; }
    public int getOpCode() { return op; }
    public int getOp() { return op; }
}