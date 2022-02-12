package com.github.cyberryan1.discordjava.http.websockets;

import com.github.cyberryan1.discordjava.http.websockets.heartbeat.Heartbeat;
import com.github.cyberryan1.discordjava.http.websockets.main.MainWebsocket;

import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

/**
 * <b>For internal use only</b>
 */
public class WebsocketManager {

    public static final CountDownLatch LATCH = new CountDownLatch( 1 );
    private static MainWebsocket mainSocket;

    /**
     * <b>For internal use only</b>
     * Establishes the connection in the {@link MainWebsocket} <br>
     * Before doing that, it initializes anything that needs to be initialized before connection is established.
     * @param uriStr Link to the webgate to establish the connection with
     * @throws URISyntaxException Thrown if the link-to-URI conversion fails
     */
    public static void connectMainSocket( String uriStr ) throws URISyntaxException {
        mainSocket = new MainWebsocket( uriStr );

        // registering the heartbeat listener
        new Heartbeat();

        mainSocket.connect();
    }

    /**
     * <b>For internal use only</b>
     * @return The main websocket
     */
    public static MainWebsocket getMain() { return mainSocket; }
}
