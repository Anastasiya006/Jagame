package jagame;

import java.awt.GraphicsEnvironment;

/**
 * Object which represents Fonts
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see GraphicsEnvironment
 * @see java.awt.Font
 */

public class Font extends java.awt.Font{

    /**
     * Constructs a new font
     * @param name The name of the font
     * @param style The style for the new <code>Font</code>
     * @param size The size for the new <code>Font</code>
     */
    public Font(String name, int style,  int size) {
        super(name, style, size);
    }

    /**
     * Creates a new Font object and applies the new font size and style to it
     * @param style the style for the new <code>Font</code>
     * @param size the size for the new <code>Font</code>
     * @return Returns the new font with the style and size applied
     */
    public Font deriveFont(int style, float size) {
        return (Font) super.deriveFont(style, size);
    }

    /**
     * Returns the default font
     * @return Returns the default laptop font
     */
    public static java.awt.Font getDefaultFont() {
        if (Display.panel != null) {
            return Display.panel.getFont();
        }
        return null;
    }

    /**
     * Gets all available fonts
     * @return Returns an array of all available font names
     */
    public static String[] getFonts() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    }
}
