package com.github.cyberryan1.discordjava.general;

import com.github.cyberryan1.discordjava.internal.JsonBodyHandler;
import com.github.cyberryan1.discordjava.internal.http.enums.DiscordLinks;
import com.github.cyberryan1.discordjava.internal.http.errors.ErrorResponseCodeException;
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

    // TODO finish javadoc comment for this method
    public void login() throws IOException, InterruptedException, URISyntaxException {
        HttpClient httpClient = HttpClient.newHttpClient();

        // requests for the gateway URL that should be used by the bot to connect with
        HttpRequest request = HttpRequest.newBuilder( DiscordLinks.GET_GATEWAY.getURI() ).build();
        HttpResponse<Supplier<DiscordGateway>> response = httpClient.send( request, new JsonBodyHandler<>( DiscordGateway.class ) );
        if ( response.statusCode() >= 400 && response.statusCode() < 500 ) {
            throw new ErrorResponseCodeException( response.statusCode() );
        }
        GATEWAY_URL = response.body().get().url;

        // starts the main websocket
        WebsocketManager.connectMainSocket( GATEWAY_URL );
        // waits until the websocket is connected
        WebsocketManager.LATCH.await();
        // identifies the bot to the discord API
        new Identify().sendIdentity( TOKEN );
    }

    public static String getGatewayURL() { return GATEWAY_URL; }
}