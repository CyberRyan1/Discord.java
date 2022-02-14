package com.github.cyberryan1.discordjava.internal.classes;

public class ActivityData {
    public int type;
    public String state;
    public String name;
    public String id;
    public long created_at;
    public ActivitiesDataTimestamps timestamps;
    public String sync_id;
    public String session_id;
    public ActivitiesDataParty party;
    public int flags;
    public String details;
    public AssetData assets;

    static class ActivitiesDataTimestamps {
        public long start;
        public long end;
    }
    static class ActivitiesDataParty {
        public String id;
    }
}