package com.github.cyberryan1.discordjava.general.classes;

/**
 * Represents all the different tags that may come with each different role
 */
public class RoleTags {

    private final long botID;

    public RoleTags( String botID ) {
        this.botID = Long.parseLong( botID );
    }

    /**
     * @return The bot ID associated with the role, if applicable
     */
    public long getBotID() {
        return botID;
    }
}