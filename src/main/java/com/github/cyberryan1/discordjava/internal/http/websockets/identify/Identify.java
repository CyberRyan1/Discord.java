package com.github.cyberryan1.discordjava.internal.http.websockets.identify;

import com.github.cyberryan1.discordjava.internal.http.websockets.WebsocketManager;

/**
 * <b>For internal use only</b>
 */
public class Identify {

    private boolean identified = false;

    // TODO add a way to customize more settings here, like presence, etc.

    /**
     * <b>For internal use only</b>
     * Sends the identity of the bot, which includes settings, etc., to the discord API
     * @param token Bot token
     */
    public void sendIdentity( String token ) {
        // i know it's a bit wack, but it's much easier to read
        String identifyStr = "{" +
                                "\"op\": 2," +
                                "\"d\": {" +
                                    "\"token\": \"" + token + "\"," +
                                    "\"properties\": {" +
                                        "\"$os\": \"" + System.getProperty( "os.name" ) + "\"," +
                                        "\"$browser\": \"discord.java\"," +
                                        "\"$device\": \"discord.java\"" +
                                    "}" +
                                "}" +
                            "}";
        WebsocketManager.getMain().send( identifyStr );
        identified = true;
    }

    /**
     * <b>For internal use only</b>
     * @return Whether the identification has been sent to the discord API
     */
    public boolean hasIdentified() { return identified; }
}