package com.github.cyberryan1.discordjava.internal.classes;

public class RoleData {
    // TODO add support for the "unicode_emoji" part of this json
    public RoleDataTags tags;
    public int position;
    public String permissions_new;
    public long permissions;
    public String name;
    public boolean mentionable;
    public boolean managed;
    public String id;
    // TODO add support for the "icon" part of this json
    public boolean hoist;
    public long color;

    static class RoleDataTags {
        public String bot_id;
    }
}