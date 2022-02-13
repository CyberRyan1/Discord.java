package com.github.cyberryan1.discordjava.internal.classes;

public class ClientData {
    public boolean verified;
    public String username;
    public boolean mfa_enabled;
    public String id; // ? in string form, can be transformed into an int
    public int flags;
    public String email; // should be null
    public String discriminator;
    public boolean bot;
    public String avatar;
}