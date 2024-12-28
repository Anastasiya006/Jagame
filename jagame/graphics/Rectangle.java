package jagame.graphics;

import java.awt.Graphics2D;
import jagame.Color;

/**
 * Class that represents a rectangle object
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see DisplayItem
 * @see java.awt.Rectangle
 */
public class Rectangle extends DisplayItem {
    private int width, height;
    private java.awt.Rectangle rect;

    /**
     * Constructs a rectangle
     * @param x The x coordinate of the rectangle
     * @param y The y coordinate of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new java.awt.Rectangle(x, y, width, height);
    }

    /**
     * Constructs a rectangle
     * @param x The x coordinate of the rectangle
     * @param y The y coordinate of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The colour of the drawn rectangle
     */
    public Rectangle(int x, int y, int width, int height, Color color) {
        this(x,y,width,height);
        this.color = color;
    }

    /**
     * Constructs a rectangle
     * @param x The x coordinate of the rectangle
     * @param y The y coordinate of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param fill If the rectangle is to be filled or not
     */
    public Rectangle(int x, int y, int width, int height, boolean fill) {
        this(x, y, width, height);
        this.fill = fill;
    }

    /**
     * Constructs a rectangle
     * @param x The x coordinate of the rectangle
     * @param y The y coordinate of the rectangle
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The colour of the drawn rectangle
     * @param fill If the rectangle is to be filled or not
     */
    public Rectangle(int x, int y, int width, int height, Color color, boolean fill) {
        this(x, y, width, height, color);
        this.fill = fill;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.rect.x = x;
        this.rect.y = y;
    }

    /**
     * Translates the rectangle a specified amount
     * @param dx the x amount to translate the item by
     * @param dy the y amount to translate the item by
     */
    public void translate(int dx, int dy) {
        super.translate(dx, dy);
        this.rect.x += dx;
        this.rect.y += dy;
    }

    public void setX(int x) {
        super.setX(x);
        this.rect.x = x;
    }
    public void setY(int y) {
        super.setY(y);
        this.rect.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * paintComponent
     * @param g2d the <code>Graphics2D</code> object which allows for visual displays
     */
    public void draw(Graphics2D g2d) {
        if (fill) {
            g2d.fillRect(x, y, width, height);
        } else {
            g2d.drawRect(x, y, width, height);
        }
    }

    /**
     * Detects collision between two rectangles
     * @param other the other rectangle this is colliding with
     * @return <code>true</code> if the rectangles are colliding
     *         <code>false</code> if the rectangles are not colliding
     */
    public boolean collide(Rectangle other) {
        return this.rect.intersects(other.rect);
    }

    /**
     * Detects if this rectangle contains the other
     * @param other the other rectangle this may contain
     * @return <code>true</code> if this contains the other rectangle
     *         <code>false</code> if this does not contain the other rectangle
     */
    public boolean contains(Rectangle other) {
        return this.rect.contains(other.rect);
    }
}
