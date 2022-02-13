package com.github.cyberryan1.discordjava.general;

import com.github.cyberryan1.discordjava.general.errors.ConnectionInterruptedException;
import com.github.cyberryan1.discordjava.general.errors.InvalidURIException;
import com.github.cyberryan1.discordjava.general.errors.LoginErrorStatusCodeException;
import com.github.cyberryan1.discordjava.general.errors.LoginRequestException;
import com.github.cyberryan1.discordjava.internal.JsonBodyHandler;
import com.github.cyberryan1.discordjava.internal.http.enums.DiscordLinks;
import com.github.cyberryan1.discordjava.internal.http.responses.DiscordGateway;
import com.github.cyberryan1.discordjava.internal.http.websockets.WebsocketManager;
import com.github.cyberryan1.discordjava.internal.http.websockets.identify.Identify;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

public class Bot {

    private static String GATEWAY_URL;

    // TODO maybe make the token only sent in the login() method and not stored here?
    private final String TOKEN;

    public Bot( String token ) {
        this.TOKEN = token;
    }

    /**
     * Establishes the connection to the discord API and identifies the bot to the API
     * @throws LoginRequestException When the request or the response to/from the API cannot be handled properly
     * @throws LoginErrorStatusCodeException When the response code from the API is an error code
     * @throws InvalidURIException When the URI link for the websocket to connect to the gateway is invalid
     * @throws ConnectionInterruptedException When the connection is interrupted by something before connection can be successfully established
     */
    public void login() {
        HttpClient httpClient = HttpClient.newHttpClient();

        // requests for the gateway URL for the websocket that should be used by the bot
        HttpRequest request = HttpRequest.newBuilder( DiscordLinks.GET_GATEWAY.getURI() ).build();
        HttpResponse<Supplier<DiscordGateway>> response = null;
        try {
            response = httpClient.send( request, new JsonBodyHandler<>( DiscordGateway.class ) );
        } catch ( IOException | InterruptedException e ) {
            throw new LoginRequestException( e );
        }
        if ( response.statusCode() >= 400 && response.statusCode() < 500 ) {
            throw new LoginErrorStatusCodeException( "Received error response code "
                    + response.statusCode() + " when sending a HTTP request" );
        }
        GATEWAY_URL = response.body().get().url;

        try {
            // starts the main websocket
            WebsocketManager.connectMainSocket( GATEWAY_URL );
            // waits until the websocket has been connected
            WebsocketManager.LATCH.await();
        } catch ( URISyntaxException e ) {
            throw new InvalidURIException( GATEWAY_URL, e );
        } catch ( InterruptedException e ) {
            throw new ConnectionInterruptedException( e );
        }

        // identifies the bot to the discord API
        new Identify().sendIdentity( TOKEN );
    }

    public static String getGatewayURL() { return GATEWAY_URL; }
}