package jagame.graphics;

import jagame.Color;
import java.awt.Graphics2D;

/**
 * This class represents an ellipse. Object of this class can be drawn onto the display.
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 */
public class Ellipse extends DisplayItem {
    private int width, height;

    /**
     * Constructs an ellipse whose upper-left corner is at (x, y), with provided width and height.
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the ellipse
     * @param height the height of the ellipse
     */
    public Ellipse(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs an ellipse whose upper-left corner is at (x, y), with provided width and height. The ellipse is
     * filled if the boolean fill is true.
     *
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the ellipse
     * @param height the height of the ellipse
     * @param fill a boolean that determines if the Rectangle is filled
     */
    public Ellipse(int x, int y, int width, int height, boolean fill){
        this(x, y, width, height);
        this.fill = fill;
    }

    /**
     * Constructs an ellipse whose upper-left corner is at (x, y), with provided width and height. The ellipse is drawn
     * using the indicated color.
     *
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the ellipse
     * @param height the height of the ellipse
     * @param color the color of the ellipse
     */
    public Ellipse(int x, int y, int width, int height, Color color){
        this(x, y, width, height);
        this.color = color;
    }

    /**
     * Constructs an ellipse whose upper-left corner is at (x, y), with provided width and height. The ellipse is
     * filled if the boolean fill is true. It is drawn using the indicated color.
     *
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the ellipse
     * @param height the height of the ellipse
     * @param color the color of the ellipse
     * @param fill a boolean that determines if the Rectangle is filled
     */
    public Ellipse(int x, int y, int width, int height, Color color, boolean fill) {
        this(x,y,width,height,color);
        this.fill = fill;
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setWidth(int width){this.width = width;}

    /**
     * Draws the ellipse object on display. Fill the ellipse if fill boolean is true.
     * @param g2d the graphics to paint on
     */
    @Override
    public void draw(Graphics2D g2d) {
        if (fill) {
            g2d.fillOval(x, y, width, height);
        } else {
            g2d.drawOval(x, y, width, height);
        }
    }

}
