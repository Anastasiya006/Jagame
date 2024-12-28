package jagame.graphics;

import jagame.Const;
import jagame.Color;
import java.awt.Graphics2D;

/**
 * Abstract class that represents DisplayItem
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 */

public abstract class DisplayItem {
    protected boolean fill = Const.DEFAULT_SHAPE_FILL;
    protected jagame.Color color = Const.DEFAULT_COLOR;
    protected int x;
    protected int y;

    /**
     * Abstract method which draws the display items
     * @param g2d Graphics2D which allows for drawing on the display screen
     */
    abstract public void draw(Graphics2D g2d);

    /**
     * Translates the display item
     * @param dx the x amount to translate the item by
     * @param dy the y amount to translate the item by
     */
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Sets the new location of the item
     * @param x the new x location
     * @param y the new y location
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean isFilled(){
        return this.fill;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(jagame.Color color){
        this.color = color;
    }
    public void setFill(boolean fill) {
        this.fill = fill;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean isFill() {
        return fill;
    }
}
