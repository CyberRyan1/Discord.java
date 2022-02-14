package com.github.cyberryan1.discordjava.internal.classes;

public class PresencesData {
    public PresencesDataUser user;
    public String status;
    public PresencesDataGame game;
    public PresencesDataStatus client_status;

    static class PresencesDataUser {
        public String id;
    }
    static class PresencesDataGame {
        public int type;
        public PresencesDataGameTimestamps timestamps;
        public String sync_id;
        public String state;
        public String session_id;
        public PresencesDataGameParty party;
        public String name;
        public String id;
        public String details;
        public int created_at;
        public AssetsData assets;

        static class PresencesDataGameTimestamps {
            public long start;
            public long end;
        }
        static class PresencesDataGameParty {
            public String id;
        }
    }
    static class PresencesDataStatus {
        public String desktop;
    }
}