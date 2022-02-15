package com.github.cyberryan1.discordjava.internal.classes;

import java.util.List;

public class ChannelData {
    public int type;
    // TODO add support for the "topic" part of this json
    public int position;
    public List<PermissionOverwritesData> permission_overwrites;
    public String parent_id;
    public String name;
    public String last_message_id;
    public String id;
    public int user_limit;
    // TODO add support for the "rtc_limit" part of this json
    public int bitrate;
    public int rate_limit_per_user;
    public boolean nsfw;
}