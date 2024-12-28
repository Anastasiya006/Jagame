package jagame.graphics;

import java.awt.Graphics2D;
import jagame.Color;

/**
 * Class that represents a polygon object
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see DisplayItem
 */

public class Polygon extends DisplayItem {
    private int[]x, y;
    private int points;

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     */
    public Polygon(int[]x, int[]y){
        this(x,y,Math.min(x.length, y.length));
    }

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     * @param points The number of points in the polygon
     */
    public Polygon(int[]x, int[]y, int points){
        this.x = x;
        this.y = y;
        this.points = points;
    }

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     * @param fill Whether the polygon is to be filled in or not
     */
    public Polygon(int[]x, int[]y, boolean fill){
        this(x,y,Math.min(x.length, y.length),fill);
    }

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     * @param color The color of the polygon
     */
    public Polygon(int[]x, int[]y, Color color){
        this(x,y,Math.min(x.length, y.length));
        this.color = color;
    }

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     * @param points The number of points in the polygon
     * @param color The colour of the polygon
     */
    public Polygon(int[]x, int[]y, int points, Color color){
        this(x, y, points);
        this.color = color;
    }

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     * @param points The number of points in the polygon
     * @param fill Whether the polygon is to be filled or not
     */
    public Polygon(int[]x, int[]y, int points, boolean fill){
        this.x = x;
        this.y = y;
        this.points = points;
        this.fill = fill;
    }

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     * @param color The colour of the polygon
     * @param fill Whether the polygon is to be filled or not
     */
    public Polygon(int[]x, int[]y, Color color, boolean fill){
        this(x,y,Math.min(x.length, y.length),fill);
        this.color = color;
    }

    /**
     * Constructs a polygon
     * @param x The x coordinates of the polygon
     * @param y The y coordinates of the polygon
     * @param points The number of points in the polygon
     * @param color The colour of the polygon
     * @param fill Whether the polygon is to be filled or not
     */
    public Polygon(int[]x, int[]y, int points, Color color, boolean fill){
        this(x,y,points,fill);
        this.color = color;
    }
    public int getPoints(){return this.points;}
    public int[] getXValues(){
        return x;
    }
    public int[]getYValues(){
        return y;
    }
    public void setX(int[] x) {
        this.x = x;
    }
    public void setY(int[] y) {
        this.y = y;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Adds a new point to the polygon
     * @param x the x coordinate of the new point
     * @param y the y coordinate of the new point
     */
    public void addPoint(int x, int y){
        int [] newX = new int[this.x.length];
        int[]newY = new int[this.y.length];

        System.arraycopy(this.x, 0, newX, 0, this.x.length);
        System.arraycopy(this.y, 0, newY, 0, this.y.length);

        newX[newX.length-1] = x;
        newY[newY.length-1] = y;
        this.points++;

        this.x = newX;
        this.y = newY;
    }

    /**
     * paintComponent
     * @param g2d the <code>Graphics2D</code> object which allows for visual displays
     */
    public void draw(Graphics2D g2d) {
        g2d.setColor(this.color);

        if(!fill) {
            g2d.drawPolygon(x, y, points);
        }else{
            g2d.fillPolygon(x, y, points);
        }

    }
}
