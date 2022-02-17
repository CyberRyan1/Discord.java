package com.github.cyberryan1.discordjava.general.classes;

/**
 * Represents a color
 */
public class Color {

    private String colorHex;

    public Color( long decimalFormat ) {
        colorHex = Long.toHexString( decimalFormat );
    }

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

    /**
     * Updates the color that is represented
     * @param newColorHex New color's hexadecimal
     */
    public void setColor( String newColorHex ) {
        colorHex = newColorHex;
    }

    /**
     * Updates the color that is represented
     * @param newColor New {@link Colors} to represent
     */
    public void setColor( Colors newColor ) {
        colorHex = newColor.hexValue;
    }

    public boolean equals( Color other ) {
        return this.getColorHex().equals( other.getColorHex() );
    }
}