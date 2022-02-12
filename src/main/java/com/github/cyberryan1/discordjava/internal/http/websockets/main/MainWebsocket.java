package com.github.cyberryan1.discordjava.internal.http.websockets.main;

import com.github.cyberryan1.discordjava.internal.classes.EventData;
import com.github.cyberryan1.discordjava.internal.http.websockets.WebsocketManager;
import com.google.gson.Gson;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <b>For internal use only</b>
 */
public class MainWebsocket extends WebSocketClient {

    private List<Object> msgListeners = new ArrayList<>();

    public MainWebsocket( URI uri, Draft draft ) {
        super( uri, draft );
    }

    public MainWebsocket( URI uri ) {
        super( uri );
    }

    public MainWebsocket( URI uri, Map<String, String> headers ) {
        super( uri, headers );
    }

    public MainWebsocket( String uri ) throws URISyntaxException {
        super( new URI( uri ) );
    }

    @Override
    public void onOpen( ServerHandshake handshake ) {
        System.out.println( "connection opened" ); // ? is this needed? do we want this for logging purposes?
        WebsocketManager.LATCH.countDown();
    }

    @Override
    public void onMessage( String message ) {
        Gson gson = new Gson();
        OpCodeData opCodeData = gson.fromJson( message, OpCodeData.class );

        if ( opCodeData.getOpCode() == 0 ) { // events are sent with opcode 0
            EventData eventData = gson.fromJson( message, EventData.class );
        }
        else {
            for ( int index = msgListeners.size() - 1; index >= 0; index-- ) {
                Object cls = msgListeners.get( index );
                for ( Method method : cls.getClass().getMethods() ) {
                    if ( method.isAnnotationPresent( WebsocketMessageHandler.class ) && method.getParameterTypes().length == 1 ) {
                        if ( method.getAnnotation( WebsocketMessageHandler.class ).value().number == opCodeData.getOpCode() ) {
                            try {
                                method.invoke( cls, message );
                            } catch ( InvocationTargetException | IllegalAccessException e ) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    // TODO put stuff here as well?
    public void onClose( int code, String reason, boolean remote ) {
        System.out.println( "Connection closed by " + ( remote ? "server" : "client" )
                + " || Code: " + code + " || Reason: " + reason );
    }

    @Override
    // TODO should this be suppressed?
    public void onError( Exception ex ) {}

    public void addMsgListener( Object cls ) {
        if ( cls.getClass().getPackageName().startsWith( "com.github.cyberryan1.discordjava" ) == false ) {
            throw new RuntimeException( "You cannot register message listeners" );
        }
        msgListeners.add( cls );
    }

    public boolean containsMsgListener( Object cls ) { return msgListeners.contains( cls ); }

    public void removeMsgListener( Object cls ) { msgListeners.remove( cls ); }
}