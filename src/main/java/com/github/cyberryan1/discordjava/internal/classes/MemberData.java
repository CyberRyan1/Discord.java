package com.github.cyberryan1.discordjava.internal.classes;

import java.util.List;

// note: Members seem to be guaranteed to not be bots
public class MemberData {
    public UserData user;
    public List<String> roles;
    // TODO add support for "premium_since"
    public boolean pending;
    public String nick;
    public boolean mute;
    public String joined_at;
    public String hoisted_role;
    public boolean deaf;
    // TODO add support for "communication_disabled_until"
    // TODO add support for "avatar"
}