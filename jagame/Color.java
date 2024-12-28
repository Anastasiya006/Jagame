package jagame;

import java.awt.color.ColorSpace;

/**
 * Class encapsulating Colors
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see java.awt.Color
 */

public class Color extends java.awt.Color {
    public static Color PINK = new Color(java.awt.Color.PINK.getRGB());
    public static Color BLACK = new Color(0, 0, 0);
    public static Color GRAY = new Color(127, 127, 127);
    public static Color WHITE = new Color (255, 255, 255);
    public static Color RED = new Color(255, 0, 0);
    public static Color GREEN = new Color(0, 255, 0);
    public static Color BLUE = new Color(0, 0, 255);
    public static Color YELLOW = new Color(255, 255, 0);
    public static Color CYAN = new Color(0, 255, 255);
    public static Color MAGENTA = new Color(255, 0, 255);

    /**
     * Creates a Color object using the RGB values
     * @param r Red value (0 to 255)
     * @param g Green value (0 to 255)
     * @param b Blue value (0 to 255)
     */
    public Color(int r, int g, int b) {
        super(r, g, b);
    }

    /**
     * Creates a Colour object using RGBA Values
     * @param r Integer representing Red value (0 to 255)
     * @param g Integer representing Green value (0 to 255)
     * @param b Integer representing Blue value (0 to 255)
     * @param a Alpha value to determine opacity
     */
    public Color(int r, int g, int b, int a) {
        super(r, g, b, a);
    }

    /**
     * Creates a Colour object using the RGB value
     * @param rgb Integer representing and combining RGB using a number from 0 to 16777215
     */
    public Color(int rgb) {
        super(rgb);
    }

    /**
     * Creates a Colour object using RGBA value and opacity
     * @param rgba Integer representing and combining RGBA values
     * @param hasalpha Integer representing colour opacity
     */
    public Color(int rgba, boolean hasalpha) {
        super(rgba, hasalpha);
    }

    /**
     * Creates a Colour object using RGB values
     * @param r Float representing Red value (0 to 255)
     * @param g Float representing Green value (0 to 255)
     * @param b Float representing Blue value (0 to 255)
     */
    public Color(float r, float g, float b) {
        super(r, g, b);
    }

    /**
     * Creates a Colour object using RGBA values
     * @param r Float representing Red value (0 to 255)
     * @param g Float representing Green value (0 to 255)
     * @param b Float representing Blue value (0 to 255)
     * @param a Float representing Alpha Opacity value
     */
    public Color(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    /**
     * Creates a Colour object using ColorSpace and Colour components
     * @param cspace ColourSpace value
     * @param components Float array representing colour components
     * @param alpha Float value representing alpha opacity
     */
    public Color(ColorSpace cspace, float[] components, float alpha) {
        super(cspace, components, alpha);
    }

    /**
     * Creates a Color object using HEX value
     * @param hex String with Colour HEX value
     */
    public Color(String hex) {
        super(Color.decode(hex).getRGB());
    }

    /**
     * Creates a Color object using java.awt Color object
     * @param color java.awt colour value
     */
    public Color(Color color){
        super(color.getRGB());
    }
}