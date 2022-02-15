package com.github.cyberryan1.discordjava.general.classes;

import com.github.cyberryan1.discordjava.internal.classes.ClientData;

/**
 * The client that represents the bot
 */
public class Client {

    private final boolean verified;
    private final String name;
    private final boolean mfaEnabled;
    private final long id;
    private final int flags;
    private final String discriminator;
    private final boolean bot;
    private final String avatar;

    public Client( ClientData data ) {
        verified = data.verified;
        name = data.username;
        mfaEnabled = data.mfa_enabled;
        id = Long.parseLong( data.id );
        flags = data.flags;
        discriminator = data.discriminator;
        bot = data.bot;
        avatar = data.avatar;
    }

    /**
     * @return True if the client is verified, false if not
     */
    public boolean isVerified() { return verified; }

    /**
     * @return Name of the client (excluding the discriminator)
     */
    public String getName() { return name; }

    /**
     * @return Discriminator of the client
     */
    public String getDiscriminator() { return discriminator; }

    /**
     * @return The name of the client AND the discriminator in the correct format <i>(ex: "YourBot#1234")</i>
     */
    public String getUsername() { return name + "#" + discriminator; }

    /**
     * @return True if the client has 2FA enabled, false if not
     */
    public boolean hasMfaEnabled() { return mfaEnabled; }

    /**
     * @return The user ID of the client
     */
    public long getID() { return id; }

    /**
     * Returns the public flags for the client.
     * <i>(See <a href="https://discord.com/developers/docs/resources/user#user-object-user-flags">Discord API</a>
     * for more information)</i>
     * @return The public flags for the client
     */
    // TODO make this return something with a flags class (or something like that)
    public int getFlags() { return flags; }

    /**
     * @return True if the client is a bot, false if not
     */
    public boolean isBot() { return bot; }

    /**
     * @return The link to the avatar of the client
     */
    public String getAvatarLink() { return avatar; }

    /**
     * Equivalent to the {@link Client#getUsername} method
     * @return The name of the client AND the discriminator in the correct format <i>(ex: "YourBot#1234")</i>
     */
    public String toString() { return getUsername(); }
}