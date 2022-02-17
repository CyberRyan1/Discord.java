package com.github.cyberryan1.discordjava.general.classes;

import com.github.cyberryan1.discordjava.internal.classes.RoleData;

import java.util.List;

/**
 * Represents a role in a discord guild
 */
public class Role {

    private final RoleTags tags;
    private final int position;
    private final String rawPermissions;
    private final String name;
    private final boolean isMentionable;
    private final boolean isManaged;
    private final long id;
    private final boolean isHoisted;
    private final long colorRawValue;

    private Color color = null;
    private List<Permission> permissionList = null;

    public Role( RoleData data ) {
        tags = new RoleTags( data.tags.bot_id );
        position = data.position;
        rawPermissions = data.permissions_new;
        name = data.name;
        isMentionable = data.mentionable;
        isManaged = data.managed;
        id = Long.parseLong( data.id );
        isHoisted = data.hoist;
        colorRawValue = data.color;
    }

    /**
     * @return The {@link RoleTags} for this role
     */
    public RoleTags getTags() {
        return tags;
    }

    /**
     * @return Position this role is on in the role list
     */
    public int getPosition() {
        return position;
    }

    /**
     * @return {@link List} of the permissions that this role has set
     */
    public List<Permission> getPermissions() {
        if ( permissionList != null ) { return permissionList; }
        permissionList = Permission.parsePermissions( rawPermissions );
        return permissionList;
    }

    /**
     * @return Raw permissions value
     */
    public String getRawPermissions() {
        return rawPermissions;
    }

    /**
     * @return Name of this role
     */
    public String getName() {
        return name;
    }

    /**
     * @return True if this role is mentionable, false if not
     */
    public boolean isMentionable() {
        return isMentionable;
    }

    /**
     * @return True if this role is managed by an application <i>(like a bot, etc.)</i>, false if not
     */
    public boolean isManaged() {
        return isManaged;
    }

    /**
     * @return ID of this role
     */
    public long getID() {
        return id;
    }

    /**
     * @return True if this role is hoisted, false if not
     */
    public boolean isHoisted() {
        return isHoisted;
    }

    /**
     * @return {@link Color} that this role uses
     */
    public Color getColor() {
        if ( color != null ) { return color; }
        color = new Color( colorRawValue );
        return color;
    }

    /**
     * @return Raw color value that this role uses
     */
    public long getRawColor() {
        return colorRawValue;
    }
}