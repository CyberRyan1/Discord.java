package com.github.cyberryan1.discordjava.general.classes;

/**
 * Represents a color
 */
public class Color {

    private String colorHex;

    public Color( String hexadecimal ) {
        colorHex = hexadecimal;
    }

    public Color( Colors color ) {
        colorHex = color.hexValue;
    }

    /**
     * @return The hexadecimal value of the color represented
     */
    public String getColorHex() {
        return colorHex;
    }

    public boolean equals( Color other ) {
        return this.getColorHex().equals( other.getColorHex() );
    }
}