package com.github.cyberryan1.discordjava.internal.http.websockets.heartbeat;

class HeartbeatServerResponse {

    private int op;
    private int d;

    public HeartbeatServerResponse() {
        op = -1;
        d = -999;
    }

    public int getOpCode() { return op; }

    public int getLastSequenceNumber() { return d; }

    public String getLastSequeuenceString() {
        return d == -999 ? "null" : "" + d;
    }
}
