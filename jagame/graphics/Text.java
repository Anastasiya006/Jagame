package jagame.graphics;

import jagame.Font;
import java.awt.Graphics2D;
import jagame.Color;

/**
 * Class that represents a text object
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see DisplayItem
 * @see Font
 */
public class Text extends DisplayItem {
    private String str;
    private Font font;
    private int fontSize;

    /**
     * Constructs a Text object
     * @param str The contents of the text
     * @param x The x coordinate of the drawn text
     * @param y The y coordinate of the drawn text
     */
    public Text(String str, int x, int y) {
        this.str = str;
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a Text object
     * @param str The contents of the text
     * @param x The x coordinate of the drawn text
     * @param y The y coordinate of the drawn text
     * @param font The font style of the drawn text
     */
    public Text(String str, int x, int y, Font font) {
        this(str, x, y);
        this.font = font;
        this.fontSize = font.getSize();
    }

    /**
     * Constructs a Text object
     * @param str The contents of the text
     * @param x The x coordinate of the drawn text
     * @param y The y coordinates of the drawn text
     * @param color The colour of the drawn text
     */
    public Text(String str, int x, int y, Color color) {
        this(str, x, y);
        this.color = color;
    }

    /**
     * Constructs a Text object
     * @param str The contents of the text
     * @param x The x coordinate of the drawn text
     * @param y The y coordinates of the drawn text
     * @param color The colour of the drawn text
     * @param font The font style of the drawn text
     */
    public Text(String str, int x, int y, Color color, Font font) {
        this(str, x, y, font);
        this.color = color;
    }

    public String getString(){
        return this.str;
    }

    public void setString(String str){
        this.str = str;
    }

    public void setFont(Font font){
        this.font = font;
    }

    public Font getFont(){
        return this.font;
    }

    public void getFontSize(int size){
        this.fontSize = size;
    }

    public int getFontSize(){
        return this.fontSize;
    }

    /**
     * paintComponent
     * @param g2d the <code>Graphics2D</code> object which allows for visual displays
     */
    @Override
    public void draw(Graphics2D g2d) {
        if (font != null) {
            g2d.setFont(font);
        }
        if (color != null) {
            g2d.setColor(color);
        }

        g2d.drawString(this.str, x, y + fontSize);
    }
}
