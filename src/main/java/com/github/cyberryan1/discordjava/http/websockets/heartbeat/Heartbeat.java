package com.github.cyberryan1.discordjava.http.websockets.heartbeat;

import com.github.cyberryan1.discordjava.http.websockets.WebsocketManager;
import com.github.cyberryan1.discordjava.http.websockets.main.OpCode;
import com.github.cyberryan1.discordjava.http.websockets.main.WebsocketMessageHandler;
import com.google.gson.Gson;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <b>For internal use only</b>
 */
public class Heartbeat {

    private static final Gson gson = new Gson();
    private static final String OPCODE_ONE = "{\"op\": 1, \"d\": ([VALUE])}"; // replace "([VALUE])" with the appropriate value

    private HeartbeatInterval heartbeatInterval;
    private HeartbeatServerResponse serverResponse = new HeartbeatServerResponse();
    private ScheduledExecutorService scheduler;
    private Future<?> future;

    public Heartbeat() {
        WebsocketManager.getMain().addMsgListener( this );
    }

    // TODO if no opcode 11 (heartbeat ACK) is sent in between heartbeats, need to reconnect

    /**
     * When an opcode 1 is received, the bot must immediately send an opcode 1 heartbeat in return
     * @param msg What was sent by discord API (json in string form)
     */
    @WebsocketMessageHandler( OpCode.ONE )
    public void onOpcodeOne( String msg ) {
        WebsocketManager.getMain().send( OPCODE_ONE.replace( "([VALUE])", serverResponse.getLastSequeuenceString() ) );
    }

    /**
     * This is what "starts" the heartbeat of the bot. <br>
     * When an opcode 10 is received, the heartbeat starts. <br>
     * First heartbeat is sent <code>( int ) ( Math.random() * HEARTBEAT_INTERVAL )</code> seconds after receiving
     * the initial opcode 10, where HEARTBEAT_INTERVAL is the specified rate to send a heartbeat by the discord API,
     * then every heartbeat after that is <code>HEARTBEAT_INTERVAL</code> seconds in between each. <br>
     * Also identifies the bot if it has not already done so.
     * @param msg What was sent by the discord API (json in string form)
     */
    @WebsocketMessageHandler( OpCode.TEN )
    public void onOpcodeTen( String msg ) {
        heartbeatInterval = gson.fromJson( msg, HeartbeatInterval.class );

        scheduler = Executors.newSingleThreadScheduledExecutor();
        future = scheduler.scheduleAtFixedRate( () -> {
            WebsocketManager.getMain().send( OPCODE_ONE.replace( "([VALUE])", serverResponse.getLastSequeuenceString() ) );
        }, ( ( int ) ( Math.random() * heartbeatInterval.getInterval() / 1000 ) ),
                heartbeatInterval.getInterval() / 1000, TimeUnit.SECONDS );
    }

    /**
     * This is the discord API acknowledging a heartbeat that was sent by the bot. <br>
     * Should be immediately sent after an opcode one heartbeat is sent by the bot.
     * @param msg What was sent by the discord API (json in string form)
     */
    @WebsocketMessageHandler( OpCode.ELEVEN )
    public void onOpcodeEleven( String msg ) {
        serverResponse = gson.fromJson( msg, HeartbeatServerResponse.class );
    }

    /**
     * Stops the bot from sending heartbeats
     */
    public void stopHeartbeat() {
        future.cancel( true );
    }
}