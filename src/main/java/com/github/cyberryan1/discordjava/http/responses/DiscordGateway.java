package com.github.cyberryan1.discordjava.http.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DiscordGateway {

    public final String status;
    public final String url;

    public DiscordGateway( @JsonProperty( "status" ) String status,
                           @JsonProperty( "url" ) String url ) {
        this.status = status;
        this.url = url;
    }
}
