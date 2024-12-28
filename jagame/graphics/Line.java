package jagame.graphics;

import java.awt.Graphics2D;
import jagame.Color;

/**
 * This class represents a line. Object of this class can be drawn onto the display.
 *
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 */
public class Line extends DisplayItem {
    private int x1, y1, x2, y2;

    /**
     * Constructs a line between the point (x1, y1) and point (x2, y2).
     * @param x1 the first point's x coordinate
     * @param y1 the first point's y coordinate
     * @param x2 the second point's x coordinate
     * @param y2 the second point's y coordinate
     */
    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Constructs a line between the point (x1, y1) and point (x2, y2), whose color is specified.
     * @param x1 the first point's x coordinate
     * @param y1 the first point's y coordinate
     * @param x2 the second point's x coordinate
     * @param y2 the second point's y coordinate
     * @param color the color of the line
     */
    public Line(int x1, int y1, int x2, int y2, Color color) {
        this(x1, y1, x2, y2);
        this.color = color;
    }

    public int getX1(){
        return this.x1;
    }
    public int getY1(){
        return this.y1;
    }
    public int getX2(){
        return this.x2;
    }
    public int getY2(){
        return this.y2;
    }
    public void setX1(int x1) {
        this.x1 = x1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * Draws the line on display.
     * @param g2d the graphics to paint on
     */
    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.drawLine(x1, y1, x2, y2);
    }
}
