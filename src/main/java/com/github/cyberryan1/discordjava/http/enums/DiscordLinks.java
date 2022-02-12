package com.github.cyberryan1.discordjava.http.enums;

import com.github.cyberryan1.discordjava.Bot;

import java.net.URI;
import java.net.URISyntaxException;

public enum DiscordLinks {

    GET_GATEWAY( "/gateway" ),
    GET_BOT_GATEWAY( "/gateway/bot" );

    private static final String DISCORD_API_LINK = "https://discord.com/api/v9";
    private final String ROUTE;

    DiscordLinks( String route ) {
        this.ROUTE = route;
    }

    public String getLink() {
        return DISCORD_API_LINK + ROUTE;
    }

    public URI getURI() {
        try {
            return new URI( DISCORD_API_LINK + ROUTE );
        } catch ( URISyntaxException ignore ) {}
        return null;
    }

    public URI getGatewayURI() {
        try {
            return new URI( Bot.getGatewayURL() + ROUTE );
        } catch ( URISyntaxException ignore ) {}
        return null;
    }
}