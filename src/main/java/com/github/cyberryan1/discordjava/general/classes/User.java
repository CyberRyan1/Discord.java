package com.github.cyberryan1.discordjava.general.classes;

import com.github.cyberryan1.discordjava.internal.classes.MemberData;
import com.github.cyberryan1.discordjava.internal.classes.UserData;

/**
 * Represents any discord user
 */
public class User {

    private final String username;
    private final int publicFlags;
    private final long id;
    private final String discriminator;
    private final boolean bot;
    private final String avatar;

    public User( UserData data ) {
        username = data.username;
        publicFlags = data.public_flags;
        id = Long.parseLong( data.id );
        discriminator = data.discriminator;
        bot = data.bot;
        avatar = data.avatar;
    }

    public User( MemberData data ) {
        username = data.user.username;
        publicFlags = data.user.public_flags;
        id = Long.parseLong( data.user.id );
        discriminator = data.user.discriminator;
        bot = false; // ? members seem to be, by default, not bots
        avatar = null; // TODO add support for "avatar" in the future
    }

    /**
     * @return Name of the user (excluding the discriminator)
     */
    public String getName() {
        return username;
    }

    /**
     * @return Discriminator of the user
     */
    public String getDiscriminator() {
        return discriminator;
    }

    /**
     * @return The name of the client AND the discriminator in the correct format <i>(ex: "RandomUser#1234")</i>
     */
    public String getUsername() {
        return username + "#" + discriminator;
    }

    /**
     * @return The id of the user
     */
    public long getID() {
        return id;
    }

    /**
     * Returns the public flags for the client.
     * <i>(See <a href="https://discord.com/developers/docs/resources/user#user-object-user-flags">Discord API</a>
     * for more information)</i>
     * @return The public flags for the client
     */
    // TODO make this return something with a flags class (or something like that)
    public int getFlags() {
        return publicFlags;
    }

    /**
     * @return True if the user is a bot, false if not
     */
    public boolean isBot() {
        return bot;
    }

    /**
     * @return The link to the avatar of the client
     */
    public String getAvatarLink() {
        return avatar;
    }

    /**
     * Equivalent to the {@link User#getUsername} method
     * @return The name of the client AND the discriminator in the correct format <i>(ex: "RandomUser#1234")</i>
     */
    public String toString() {
        return username + "#" + discriminator;
    }
}