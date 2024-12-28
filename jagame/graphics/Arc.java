package jagame.graphics;

import java.awt.Graphics2D;
import jagame.Color;

/**
 * This class represents an arc. Object of this class can be drawn onto the display.
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see jagame.graphics.DisplayItem
 * @see java.awt.Graphics
 */
public class Arc extends DisplayItem {

    private int width;
    private int height;
    private int startAngle;
    private int arcAngle;

    /**
     * Constructs a new arc whose upper-left corner is at (x, y), with provided width, height, startAngle and arcAngle.
     * <p></p>
     * The arc is contained in the rectangle with dimensions (width, height). The arc starts at startAngle degrees
     * counter-clockwise from the 3 o'clock direction and goes arcAngle degrees.
     *
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the arc
     * @param height the height of the arc
     * @param startAngle the start angle of the arc
     * @param arcAngle the angle the arc extents
     */
    public Arc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
    }

    /**
     * Constructs a new arc whose upper-left corner is at (x, y), with provided width, height, startAngle and arcAngle.
     * The arc is filled if the boolean fill is true.
     * <p></p>
     * The arc is contained in the rectangle with dimensions (width, height). The arc starts at startAngle degrees
     * counter-clockwise from the 3 o'clock direction and goes arcAngle degrees.
     *
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the arc
     * @param height the height of the arc
     * @param startAngle the start angle of the arc
     * @param arcAngle the angle the arc extents
     * @param fill a boolean that determines if the Rectangle is filled
     */
    public Arc(int x, int y, int width, int height, int startAngle, int arcAngle, Boolean fill) {
        this(x, y, width, height, startAngle, arcAngle);
        this.fill = fill;
    }

    /**
     * Constructs a new arc whose upper-left corner is at (x, y), with provided width, height, startAngle and arcAngle.
     * The arc is drawn using the indicated color.
     * <p></p>
     * The arc is contained in the rectangle with dimensions (width, height). The arc starts at startAngle degrees
     * counter-clockwise from the 3 o'clock direction and goes arcAngle degrees.
     *
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the arc
     * @param height the height of the arc
     * @param startAngle the start angle of the arc
     * @param arcAngle the angle the arc extents
     * @param color the color of the arc
     */
    public Arc(int x, int y, int width, int height, int startAngle, int arcAngle, Color color) {
        this(x, y, width, height, startAngle, arcAngle);
        this.color = color;
    }

    /**
     * Constructs a new arc whose upper-left corner is at (x, y), with provided width, height, startAngle and arcAngle.
     * The arc is filled if the boolean fill is true. It is drawn using the indicated color.
     * <p></p>
     * The arc is contained in the rectangle with dimensions (width, height). The arc starts at startAngle degrees
     * counter-clockwise from the 3 o'clock direction and goes arcAngle degrees.
     *
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     * @param width the width of the arc
     * @param height the height of the arc
     * @param startAngle the start angle of the arc
     * @param arcAngle the angle the arc extents
     * @param color the color of the arc
     * @param fill a boolean that determines if the Rectangle is filled
     */
    public Arc(int x, int y, int width, int height, int startAngle, int arcAngle, Color color, boolean fill) {
        this(x, y, width, height, startAngle, arcAngle, color);
        this.fill = fill;
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public int getStartAngle(){
        return this.startAngle;
    }
    public int getArcAngle(){
        return this.arcAngle;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }
    public void setArcAngle(int arcAngle) {
        this.arcAngle = arcAngle;
    }

    /**
     * Draws the arc object on display. Fill the arc if fill boolean is true.
     * @param g2d the graphics to paint on
     */
    @Override
    public void draw(Graphics2D g2d) {
        if (fill) {
            g2d.fillArc(x, y, width, height, startAngle, arcAngle);
        } else {
            g2d.drawArc(x, y, width, height, startAngle, arcAngle);
        }
    }
}
