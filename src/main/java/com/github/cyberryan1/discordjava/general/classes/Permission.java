package com.github.cyberryan1.discordjava.general.classes;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * Contains all the permissions that may be used in a discord guild.
 * Also has a lot of helper methods, if needed.
 */
public enum Permission {

    /**
     * Allows users to create instant invites <br>
     * Applies to text, voice, and stage channels
     */
    CREATE_INSTANT_INVITE ( getShift( 0 ), false ),

    /**
     * Allows a user to kick other members
     */
    KICK_MEMBERS ( getShift( 1 ), true ),

    /**
     * Allows a user to ban other members
     */
    BAN_MEMBERS ( getShift( 2 ), true ),

    /**
     * Gives all permission to a channel, including the ability to bypass channel permission overwrites
     */
    ADMINISTRATOR ( getShift( 3 ), true ),

    /**
     * Allows a user to create, edit, and delete channels <br>
     * Applies to text, voice, and stage channels
     */
    MANAGE_CHANNELS ( getShift( 4 ), true ),

    /**
     * Allows a user to manage and edit the guild
     */
    MANAGE_GUILD ( getShift( 5 ), true ),

    /**
     * Allows a user to add reactions to messages <br>
     * Applies to text channels
     */
    ADD_REACTIONS ( getShift( 6 ), false ),

    /**
     * Allows a user to view the guild's audit logs
     */
    VIEW_AUDIT_LOG ( getShift( 7 ), false ),

    /**
     * Allows a user to be a priority speaker in a voice channel <br>
     * Applies to voice channels
     */
    PRIORITY_SPEAKER ( getShift( 8 ), false ),

    /**
     * Allows a user to stream in a voice channel <br>
     * Applies to voice channels
     */
    STREAM ( getShift( 9 ), false ),

    /**
     * Allows a user to view a channel <br>
     * Applies to text, voice, and stage channels
     */
    VIEW_CHANNEL ( getShift( 10 ), false ),

    /**
     * Allows a user to send messages <i>(this does not include being able to send messages in threads)</i> <br>
     * Applies to text channels
     */
    SEND_MESSAGES ( getShift( 11 ), false ),

    /**
     * Allows a user to use the <code>/tts</code> <i>(text to speech)</i> commands <br>
     * Applies to text channels
     */
    SEND_TTS_MESSAGES ( getShift( 12 ), false ),

    /**
     * Allows a user to delete other users messages <br>
     * Applies to text channels
     */
    MANAGE_MESSAGES ( getShift( 13 ), true ),

    /**
     * Allows a user to send links that are automatically embedded <br>
     * Applies to text channels
     */
    EMBED_LINKS ( getShift( 14 ), false ),

    /**
     * Allows a user to upload images and other files to a channel <br>
     * Applies to text channels
     */
    ATTACH_FILES ( getShift( 15 ), false ),

    /**
     * Allows a user to read the history within a channel <br>
     * Applies to text channels
     */
    READ_MESSAGE_HISTORY ( getShift( 16 ), false ),

    /**
     * Allows a user to use the <code>@everyone</code> mention <br>
     * Applies to text channels
     */
    MENTION_EVERYONE( getShift( 17 ), false ),

    /**
     * Allows a user to send custom emojis <i>(from other servers)</i> in this discord server <br>
     * Applies to text channels
     * <br><br><i>(please use carefully <3)</i>
     */
    USE_EXTERNAL_EMOJIS ( getShift( 18 ), false ),

    /**
     * Allows a user to see the guild's insights
     */
    VIEW_GUILD_INSIGHTS ( getShift( 19 ), false ),

    /**
     * Allows a user to connect to a voice channel <br>
     * Applies to voice and stage channels
     */
    CONNECT ( getShift( 20 ), false ),

    /**
     * Allows a user to speak in a voice channel <br>
     * Applies to voice channels
     */
    SPEAK ( getShift( 21 ), false ),

    /**
     * Allows a user to server mute other users <br>
     * Applies to voice and stage channels
     */
    MUTE_MEMBERS ( getShift( 22 ), false ),

    /**
     * Allows a user to server deafen other users <br>
     * Applies to voice and stage channels
     */
    DEAFEN_MEMBERS ( getShift( 23 ), false ),

    /**
     * Allows a user to move another user between voice channels <br>
     * Applies to voice and stage channels
     */
    MOVE_MEMBERS ( getShift( 24 ), false ),

    /**
     * Allows a user to use voice activity in a voice channel <br>
     * Applies to voice channels
     */
    USE_VOICE_ACTIVITY ( getShift( 25 ), false ),

    /**
     * Allows a user to change their nickname
     */
    CHANGE_NICKNAME ( getShift( 26 ), false ),

    /**
     * Allows a user to change other user's nicknames
     */
    MANAGE_NICKNAMES ( getShift( 27 ), false ),

    /**
     * Allows a user to manage roles and edit a user's role list
     */
    MANAGE_ROLES ( getShift( 28 ), true ),

    /**
     * Allows a user to manage and/or edit webhooks
     */
    MANAGE_WEBHOOKS ( getShift( 29 ), true ),

    /**
     * Allows a user to add and remove server emojis and stickers
     */
    MANAGE_EMOJIS_STICKERS ( getShift( 30 ), true ),

    /**
     * Allows a user to use slash commands that are provided by applications
     */
    USE_SLASH_COMMANDS ( getShift( 31 ), false ),

    /**
     * Allows a user to request to speak in stage channels <br>
     * Applies to stage channels
     */
    REQUEST_SPEAK ( getShift( 32 ), false ),

    /**
     * Allows a user to create, edit, and remove events
     */
    MANAGE_EVENTS ( getShift( 33 ), false ),

    /**
     * Allows a user to delete, archive, and view all private threads
     */
    MANAGE_THREADS ( getShift( 34 ), true ),

    /**
     * Allows a user to create public threads
     */
    CREATE_PUBLIC_THREADS ( getShift( 35 ), false ),

    /**
     * Allows a user to create private threads
     */
    CREATE_PRIVATE_THREADS ( getShift( 36 ), false ),

    /**
     * Allows a user to send stickers from other servers <br>
     * Applies to text channels
     */
    USE_EXTERNAL_STICKERS ( getShift( 37 ), false ),

    /**
     * Allows a user to send messages in threads
     */
    SEND_MESSAGES_IN_THREADS ( getShift( 38 ), false ),

    /**
     * Allows a user to start activities
     */
    START_ACTIVITIES ( getShift( 39 ), false ),

    /**
     * Allows a user to timeout other users
     */
    TIMEOUT_MEMBERS ( getShift( 40 ), true );

    final BigInteger permissionValue;
    final boolean authenticationRequired;
    Permission( BigInteger permValue, boolean authReq ) {
        permissionValue = permValue;
        authenticationRequired = authReq;
    }

    /**
     * Parses a decimal number (in a {@link String}) and returns a list of permissions that it represents
     * @param permissions Decimal number representing the permissions (in a {@link String})
     * @return {@link List} of the permissions represented in the inputted variable
     */
    public static List<Permission> parsePermissions( String permissions ) {
        BigInteger perms = new BigInteger( permissions );
        return Arrays.stream( Permission.values() )
                .filter( ( value ) ->
                        ( perms.and( value.permissionValue ).equals( value.permissionValue ) ) )
                .toList();
    }

    /**
     * Combines a list of permissions into a single {@link BigInteger}
     * @param permissions Array of permissions to combine
     * @return {@link BigInteger} representing the permissions value
     */
    public static BigInteger getPermissionsValue( Permission ... permissions ) {
        if ( permissions.length == 0 ) { return null; }
        if ( permissions.length == 1 ) { return permissions[0].permissionValue; }
        BigInteger toReturn = permissions[0].permissionValue;
        for ( int index = 1; index < permissions.length; index++ ) {
            toReturn = toReturn.or( permissions[index].permissionValue );
        }
        return toReturn;
    }

    /**
     * Combines a list of permissions into a single {@link BigInteger}
     * @param permissions {@link List} of permissions to combine
     * @return {@link BigInteger} representing the permissions value
     */
    public static BigInteger getPermissionsValue( List<Permission> permissions ) {
        if ( permissions.size() == 0 ) { return null; }
        if ( permissions.size() == 1 ) { return permissions.get( 0 ).permissionValue; }
        BigInteger toReturn = permissions.get( 0 ).permissionValue;
        for ( int index = 1; index < permissions.size(); index++ ) {
            toReturn = toReturn.or( permissions.get( index ).permissionValue );
        }
        return toReturn;
    }

    /**
     * Checks if a permission is in a permission integer
     * @param permissions {@link BigInteger} of the permissions integer
     * @param perm {@link Permission} to check
     * @return True if the <code>perm</code> parameter's value is in the <code>permissions</code> parameter, false if not
     */
    public static boolean hasPermission( BigInteger permissions, Permission perm ) {
        return permissions.and( perm.permissionValue ).equals( perm.permissionValue );
    }

    /**
     * Checks if a permission integer contains all permissions in a permissions array
     * @param permissions {@link BigInteger} of the permissions integer
     * @param perms Array of the permissions
     * @return True if the <code>permissions</code> parameter contains all <code>perms</code>, false if not
     */
    public static boolean hasPermissions( BigInteger permissions, Permission ... perms ) {
        return Arrays.stream( perms ).allMatch( ( p ) -> ( permissions.and( p.permissionValue ).equals( p.permissionValue ) ) );
    }

    /**
     * Checks if a permission integer contains all permissions in a permissions array
     * @param permissions {@link BigInteger} of the permissions integer
     * @param perms {@link List} of the permissions
     * @return True if the <code>permissions</code> parameter contains all <code>perms</code>, false if not
     */
    public static boolean hasPermissions( BigInteger permissions, List<Permission> perms ) {
        return perms.stream().allMatch( ( p ) -> ( permissions.and( p.permissionValue ).equals( p.permissionValue ) ) );
    }

    private static BigInteger getShift( int shiftBy ) {
        return new BigInteger( "" + ( 1 << shiftBy ) );
    }
}