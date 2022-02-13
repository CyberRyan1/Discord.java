package com.github.cyberryan1.discordjava.general.events;

import com.github.cyberryan1.discordjava.general.classes.Client;
import com.github.cyberryan1.discordjava.general.events.handler.EventType;
import com.github.cyberryan1.discordjava.internal.classes.ClientData;
import com.github.cyberryan1.discordjava.internal.classes.PartialApplicationData;
import com.github.cyberryan1.discordjava.internal.classes.PartialGuildData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Fired when the bot has connected to the websocket successfully and has completed the initial handshake.
 */
public class ReadyEvent {

    public static final EventType EVENT_TYPE = EventType.ON_READY;
    private static final Gson gson = new Gson();

    private final String RAW_DATA;
    private final ReadyEventDataJSON DATA_JSON;
    private final ReadyEventDataJSON.Data DATA;

    private Client client;
    private List<Long> guildIDList;

    public ReadyEvent( String data ) {
        RAW_DATA = data;
        DATA_JSON = gson.fromJson( RAW_DATA, ReadyEventDataJSON.class );
        DATA = DATA_JSON.d;
    }

    /**
     * @return The client represented by this bot
     */
    public Client getClient() {
        if ( client == null ) { client = new Client( DATA.user ); }
        return client;
    }

    /**
     * @return The session ID for this current connection of the bot
     */
    public String getSessionID() { return DATA.session_id; }

    /**
     * @return List of the guild IDs the bot is in
     */
    public List<Long> getGuilds() {
        if ( guildIDList == null ) {
            guildIDList = new ArrayList<>();
            DATA.guilds.forEach( ( partialData ) -> {
                guildIDList.add( Long.parseLong( partialData.id ) );
            } );
        }
        return guildIDList;
    }
}

/**
 * Represents the data sent by the discord API for this event
 */
class ReadyEventDataJSON {
    public String t;
    public int s;
    public int op;
    public Data d;

    static class Data {
        public int v;
        // TODO add support for the "user_settings" part of this json
        public ClientData user;
        public String session_id;
        // TODO add support for the "relationships" part of this json
        // TODO add support for the "presences" part of this json
        public List<PartialGuildData> guilds;
        // TODO add support for the "guild_join_requests" part of the json
        // * ignored the "geo_ordered_rtc_regions" part of the json
        public PartialApplicationData application; // ? is this needed?
    }
}