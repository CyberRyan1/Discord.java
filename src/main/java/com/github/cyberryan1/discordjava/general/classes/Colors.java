package com.github.cyberryan1.discordjava.general.classes;

// TODO add javadocs later
public enum Colors {
    GRAY ( "#808080" ),
    LIME ( "#00FF00" ),
    AQUA ( "#00FFFF" ),
    PURPLE ( "#800080" ),
    RED ( "#FF0000" ),
    DARK_RED ( "#8B0000" ),
    GOLD ( "#FFD700" ),
    ORANGE ( "#FFA500" ),
    YELLOW ( "#FFFF00" ),
    GREEN ( "#006400" ),
    LIGHT_BLUE ( "#6495ED" ),
    BLUE ( "#0000CD" ),
    WHITE ( "#FFFFFF" ),
    BROWN ( "#8B4513" );

    public final String hexValue;
    Colors( String hexValue ) {
        this.hexValue = hexValue;
    }
}