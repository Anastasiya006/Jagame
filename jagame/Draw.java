package jagame;

import jagame.graphics.*;
import java.awt.image.BufferedImage;

/**
 * This class is used to draw graphics on display.
 * <p>
 * The provided graphics will be added to the queue in Display class, displayItems. Then later drawn onto the display.
 *
 * @version Jan 2024
 * @author  Vivian Ji
 * @author  Anastasiya Volgina
 * @author  Claire Guo
 * @see     Display
 * @see     jagame.graphics
 * @see     jagame.Color
 */

public class Draw {

    /**
     * The color assigned to the shapes without a specified color.
     */
    protected static jagame.Color color = Const.DEFAULT_COLOR; //default color

    /**
     * Draws a Rectangle border.
     * @param x the x coordinate of the upper-left corner of the Rectangle
     * @param y the y coordinate of the upper-left corner of the Rectangle
     * @param width the width of the Rectangle
     * @param height the height of the Rectangle
     */
    public static void rect(int x, int y, int width, int height) {
        Display.displayItems.add(new Rectangle(x, y, width, height, color));
    }

    /**
     * Draws a Rectangle.
     * @param x the x coordinate of the upper-left corner of the Rectangle
     * @param y the y coordinate of the upper-left corner of the Rectangle
     * @param width the width of the Rectangle
     * @param height the height of the Rectangle
     * @param fill a boolean that determines if the Rectangle is filled
     */
    public static void rect(int x, int y, int width, int height, boolean fill) {
        Display.displayItems.add(new Rectangle(x, y, width, height, color, fill));
    }

    /**
     * Draws a Rectangle border using the indicated color.
     * @param x the x coordinate of the upper-left corner of the Rectangle
     * @param y the y coordinate of the upper-left corner of the Rectangle
     * @param width the width of the Rectangle
     * @param height the height of the Rectangle
     * @param color the color of the Rectangle
     */
    public static void rect(int x, int y, int width, int height, jagame.Color color) {
        Display.displayItems.add(new Rectangle(x, y, width, height, color));
    }

    /**
     * Draws a Rectangle using the indicated color.
     * @param x the x coordinate of the upper-left corner of the Rectangle
     * @param y the y coordinate of the upper-left corner of the Rectangle
     * @param width the width of the Rectangle
     * @param height the height of the Rectangle
     * @param color the color of the Rectangle
     * @param fill a boolean that determines if the Rectangle is filled
     */
    public static void rect(int x, int y, int width, int height, jagame.Color color, boolean fill) {
        Display.displayItems.add(new Rectangle(x,y,width,height,color, fill));
    }

    /**
     * Draws a Rectangle.
     * @param rectangle the Rectangle to be drawn
     */
    public static void rect(Rectangle rectangle) {
        Display.displayItems.add(rectangle);
    }

    /**
     * Draws a Rectangle at specified coordinate.
     * @param rectangle the Rectangle to be drawn
     * @param x the x coordinate of the upper-left corner of the Rectangle
     * @param y the y coordinate of the upper-left corner of the Rectangle
     */
    public static void rect(Rectangle rectangle, int x, int y) {
        rectangle.setLocation(x, y);
        Display.displayItems.add(rectangle);
    }

    /**
     * Draws an Arc outline.
     * The 0-degree angle is at 3 o'clock position, same as 0 degree in coordinate system. Positive angle turns
     * counter-clockwise, negative angle turns clockwise.
     * <p>
     * The Arc begins at startAngle, extends for arcAngle degrees.
     *
     * @param x the x coordinate of the upper-left corner of the Arc
     * @param y the y coordinate of the upper-left corner of the Arc
     * @param width the width of the Arc
     * @param height the height of the Arc
     * @param startAngle the beginning angle
     * @param arcAngle the angular extent of the Arc, relative to the start angle
     */
    public static void arc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        Display.displayItems.add(new Arc(x,y,width,height,startAngle,arcAngle, color));
    }

    /**
     * Draws an Arc.
     * The 0-degree angle is at 3 o'clock position, same as 0 degree in coordinate system. Positive angle turns
     * counter-clockwise, negative angle turns clockwise.
     * <br><br>
     * The Arc begins at startAngle, extends for arcAngle degrees.
     *
     * @param x the x coordinate of the upper-left corner of the Arc
     * @param y the y coordinate of the upper-left corner of the Arc
     * @param width the width of the Arc
     * @param height the height of the Arc
     * @param startAngle the beginning angle
     * @param arcAngle the angular extent of the Arc, relative to the start angle
     * @param fill a boolean that determines if the Arc is filled
     */
    public static void arc(int x, int y, int width, int height, int startAngle, int arcAngle, boolean fill) {
        Display.displayItems.add(new Arc(x,y,width,height,startAngle,arcAngle, color, fill));
    }

    /**
     * Draws an Arc outline using the indicated color.
     * The 0-degree angle is at 3 o'clock position, same as 0 degree in coordinate system. Positive angle turns
     * counter-clockwise, negative angle turns clockwise.
     * <br><br>
     * The Arc begins at startAngle, extends for arcAngle degrees.
     *
     * @param x the x coordinate of the upper-left corner of the Arc
     * @param y the y coordinate of the upper-left corner of the Arc
     * @param width the width of the Arc
     * @param height the height of the Arc
     * @param startAngle the beginning angle
     * @param arcAngle the angular extent of the Arc, relative to the start angle
     * @param color the color of the Arc
     */
    public static void arc(int x, int y, int width, int height, int startAngle, int arcAngle, jagame.Color color) {
        Display.displayItems.add(new Arc(x,y,width,height,startAngle,arcAngle, color));
    }

    /**
     * Draws a filled Arc using the indicated color.
     * The 0-degree angle is at 3 o'clock position, same as 0 degree in coordinate system. Positive angle turns
     * counter-clockwise, negative angle turns clockwise.
     * <br><br>
     * The Arc begins at startAngle, extends for arcAngle degrees.
     *
     * @param x the x coordinate of the upper-left corner of the Arc
     * @param y the y coordinate of the upper-left corner of the Arc
     * @param width the width of the Arc
     * @param height the height of the Arc
     * @param startAngle the beginning angle
     * @param arcAngle the angular extent of the Arc, relative to the start angle
     * @param color the color of the Arc
     * @param fill a boolean that determines if the Arc is filled
     */
    public static void arc(int x, int y, int width, int height, int startAngle, int arcAngle, jagame.Color color, boolean fill) {
        Display.displayItems.add(new Arc(x,y,width,height,startAngle,arcAngle, color, fill));
    }

    /**
     * Draws an Arc.
     * @param arc the Arc to be drawn
     */
    public static void arc(Arc arc){
        Display.displayItems.add(arc);
    }

    /**
     * Draws an Arc at the specified coordinate.
     * @param arc the Arc to be drawn
     * @param x the x coordinate of the upper-left corner of the Arc
     * @param y the y coordinate of the upper-left corner of the Arc
     */
    public static void arc(Arc arc, int x, int y){
        arc.setLocation(x, y);
        Display.displayItems.add(arc);
    }

    /**
     * Draws an Ellipse outline.
     * @param x the x coordinate of the upper-left corner of the Ellipse
     * @param y the y coordinate of the upper-left corner of the Ellipse
     * @param width the width of the Ellipse
     * @param height the height of the Ellipse
     */
    public static void ellipse(int x, int y, int width, int height){
        Display.displayItems.add(new Ellipse(x,y,width,height,color));
    }

    /**
     * Draws an Ellipse.
     * @param x the x coordinate of the upper-left corner of the Ellipse
     * @param y the y coordinate of the upper-left corner of the Ellipse
     * @param width the width of the Ellipse
     * @param height the height of the Ellipse
     * @param fill a boolean that determines if the Ellipse is filled
     */
    public static void ellipse(int x, int y, int width, int height, boolean fill){
        Display.displayItems.add(new Ellipse(x,y,width,height,color,fill));
    }

    /**
     * Draws an Ellipse outline using the indicated color.
     * @param x the x coordinate of the upper-left corner of the Ellipse
     * @param y the y coordinate of the upper-left corner of the Ellipse
     * @param width the width of the Ellipse
     * @param height the height of the Ellipse
     * @param color the color of the Ellipse
     */
    public static void ellipse(int x, int y, int width, int height, jagame.Color color){
        Display.displayItems.add(new Ellipse(x,y,width,height,color));
    }
    /**
     * Draws an Ellipse using the indicated color.
     * @param x the x coordinate of the upper-left corner of the Ellipse
     * @param y the y coordinate of the upper-left corner of the Ellipse
     * @param width the width of the Ellipse
     * @param height the height of the Ellipse
     * @param color the color of the Ellipse
     * @param fill a boolean that determines if the Ellipse is filled
     */
    public static void ellipse(int x, int y, int width, int height, jagame.Color color, boolean fill){
        Display.displayItems.add(new Ellipse(x,y,width,height,color,fill));
    }

    /**
     * Draws an Ellipse.
     * @param ellipse the Ellipse to be drawn
     */
    public static void ellipse(Ellipse ellipse){
        Display.displayItems.add(ellipse);
    }
    /**
     * Draws an Ellipse at the specified coordinate.
     * @param ellipse the Ellipse to be drawn
     * @param x the x coordinate of the upper-left corner of the Ellipse
     * @param y the y coordinate of the upper-left corner of the Ellipse
     */
    public static void ellipse(Ellipse ellipse, int x, int y){
        ellipse.setLocation(x, y);
        Display.displayItems.add(ellipse);
    }

    /**
     * Draws a circle outline.
     * @param x the x coordinate of the upper-left corner of the circle
     * @param y the y coordinate of the upper-left corner of the circle
     * @param radius the radius of the circle
     */
    public static void circle(int x, int y, int radius) {
        Display.displayItems.add(new Ellipse(x,y,radius, radius, color));
    }

    /**
     * Draws a circle outline using the indicated color.
     * @param x the x coordinate of the upper-left corner of the circle
     * @param y the y coordinate of the upper-left corner of the circle
     * @param radius the radius of the circle
     * @param color the color of the circle
     */
    public static void circle(int x, int y, int radius, jagame.Color color) {
        Display.displayItems.add(new Ellipse(x,y,radius, radius, color));
    }

    /**
     * Draws a circle.
     * @param x the x coordinate of the upper-left corner of the circle
     * @param y the y coordinate of the upper-left corner of the circle
     * @param radius the radius of the circle
     * @param fill a boolean that determines if the circle is filled
     */
    public static void circle(int x, int y, int radius, boolean fill) {
        Display.displayItems.add(new Ellipse(x,y,radius, radius,color, fill));
    }

    /**
     * Draws a circle using the indicated color.
     * @param x the x coordinate of the upper-left corner of the circle
     * @param y the y coordinate of the upper-left corner of the circle
     * @param radius the radius of the circle
     * @param color the color of the circle
     * @param fill a boolean that determines if the circle is filled
     */
    public static void circle(int x, int y, int radius, jagame.Color color, boolean fill) {
        Display.displayItems.add(new Ellipse(x,y,radius, radius, color, fill));
    }

    /**
     * Draws a circle.
     * @param circle the circle to be drawn
     */
    public static void circle(Ellipse circle){
        Display.displayItems.add(circle);
    }

    /**
     * Draws a circle.
     * @param circle the circle to be drawn
     * @param x the x coordinate of the upper-left corner of the circle
     * @param y the y coordinate of the upper-left corner of the circle
     */
    public static void circle(Ellipse circle, int x, int y){
        circle.setLocation(x, y);
        Display.displayItems.add(circle);
    }

    /**
     * Draws a Line between points (x1, y1) and (x2, y2).
     * @param x1 the first point's x coordinate
     * @param y1 the first point's y coordinate
     * @param x2 the second point's x coordinate
     * @param y2 the second point's y coordinate
     */
    public static void line(int x1, int y1, int x2, int y2) {
        Display.displayItems.add(new Line(x1, y1, x2, y2, color));
    }

    /**
     * Draws a Line between points (x1, y1) and (x2, y2) using the indicated color.
     * @param x1 the first point's x coordinate
     * @param y1 the first point's y coordinate
     * @param x2 the second point's x coordinate
     * @param y2 the second point's y coordinate
     * @param color the color of the Line
     */
    public static void line(int x1, int y1, int x2, int y2, Color color) {
        Display.displayItems.add(new Line(x1,y1,x2,y2,color));
    }

    /**
     * Draws a Line.
     * @param line the Line to be drawn
     */
    public static void line(Line line){
        Display.displayItems.add(line);
    }

    /**
     * Draws a Line.
     * @param line the Line to be drawn
     */
    public static void line(Line line, Color color){
        line.setColor(color);
        Display.displayItems.add(line);
    }

    /**
     * Draws an Image.
     * @param filePath a String of the Image's path
     * @param x the x coordinate of the upper-left corner of the Image
     * @param y the y coordinate of the upper-left corner of the Image
     */
    public static void image(String filePath, int x, int y){
        Display.displayItems.add(new Image(filePath, x,y));
    }

    /**
     * Draws an Image.
     * @param image the Image to be drawn
     */
    public static void image(Image image){
        Display.displayItems.add(image);
    }

    /**
     * Draws an Image at specified coordinate.
     * @param image the Image to be drawn
     * @param x the x coordinate of the upper-left corner of the Image
     * @param y the y coordinate of the upper-left corner of the Image
     */
    public static void image(Image image, int x, int y){
        image.setLocation(x, y);
        Display.displayItems.add(image);
    }

    /**
     * Draws an Image from loaded BufferedImage.
     * @param image a BufferedImage to be drawn
     */
    public static void image(BufferedImage image) {
        Display.displayItems.add(new Image(image));
    }

    /**
     * Draws an Image from loaded BufferedImage at specified location.
     * @param image a BufferedImage to be drawn
     * @param x the x coordinate of the upper-left corner of the Image
     * @param y the y coordinate of the upper-left corner of the Image
     */
    public static void image(BufferedImage image, int x, int y) {
        Display.displayItems.add(new Image(image, x, y));
    }

    /**
     * Draws a Polygon outline from given arrays of x and y coordinates.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     */
    public static void polygon(int[]x, int[]y) {
        Display.displayItems.add(new Polygon(x,y));
    }

    /**
     * Draws a Polygon outline from given arrays of x and y coordinates.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     * @param nPoints the number of points of the Polygon
     */
    public static void polygon(int[]x, int[]y, int nPoints) {
        Display.displayItems.add(new Polygon(x,y,nPoints, color));
    }

    /**
     * Draws a Polygon from given arrays of x and y coordinates.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     * @param fill a boolean that determines if the Polygon is filled
     */
    public static void polygon(int[]x, int[]y, boolean fill){
        Display.displayItems.add(new Polygon(x,y,color,fill));
    }

    /**
     * Draws a Polygon outline from given arrays of x and y coordinates using the indicated color.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     * @param color the color of the Polygon
     */
    public static void polygon(int[]x, int[]y, Color color){
        Display.displayItems.add(new Polygon(x,y,color));
    }

    /**
     * Draws a Polygon from given arrays of x and y coordinates using the indicated color.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     * @param nPoints the number of points of the Polygon
     * @param fill a boolean that determines if the Polygon is filled
     */
    public static void polygon(int[]x, int[]y, int nPoints, boolean fill) {
        Display.displayItems.add(new Polygon(x,y,nPoints, color, fill));
    }

    /**
     * Draws a Polygon outline from given arrays of x and y coordinates using the indicated color.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     * @param nPoints the number of points of the Polygon
     * @param color the color of the Polygon
     */
    public static void polygon(int[]x, int[]y, int nPoints, Color color) {
        Display.displayItems.add(new Polygon(x,y,nPoints, color));
    }

    /**
     * Draws a Polygon from given arrays of x and y coordinates using the indicated color.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     * @param color the color of the Polygon
     * @param fill a boolean that determines if the Polygon is filled
     */
    public static void polygon(int[]x, int[]y, Color color, boolean fill) {
        Display.displayItems.add(new Polygon(x,y, color, fill));
    }

    /**
     * Draws a Polygon from given arrays of x and y coordinates using the indicated color.
     * @param x an array of x coordinates
     * @param y an array of y coordinates
     * @param nPoints the number of points of the Polygon
     * @param color the color of the Polygon
     * @param fill a boolean that determines if the Polygon is filled
     */
    public static void polygon(int[]x, int[]y, int nPoints, Color color, boolean fill){
        Display.displayItems.add(new Polygon(x,y,nPoints,color,fill));
    }

    /**
     * Draws a Polygon.
     * @param polygon the polygon to be drawn
     */
    public static void polygon(Polygon polygon){
        Display.displayItems.add(polygon);
    }

    /**
     * Draws the Text.
     * @param str the string to be displayed
     * @param x the x coordinate of the upper-left corner of the Text
     * @param y the y coordinate of the upper-left corner of the Text
     */
    public static void text(String str, int x, int y) {
        Display.displayItems.add(new Text(str,x,y,color));
    }

    /**
     * Draws the Text using the indicated font.
     * @param str the string to be displayed
     * @param x the x coordinate of the upper-left corner of the Text
     * @param y the y coordinate of the upper-left corner of the Text
     * @param font the font of the text to be displayed
     */
    public static void text(String str, int x, int y, Font font) {
        Display.displayItems.add(new Text(str,x,y,color,font));
    }

    /**
     * Draws the Text using the indicated color.
     * @param str the string to be displayed
     * @param x the x coordinate of the upper-left corner of the Text
     * @param y the y coordinate of the upper-left corner of the Text
     * @param color the color of the text to be displayed
     */
    public static void text(String str, int x, int y, Color color) {
        Display.displayItems.add(new Text(str,x,y,color));
    }

    /**
     * Draws the Text using the indicated font with the color.
     * @param str the string to be displayed
     * @param x the x coordinate of the upper-left corner of the Text
     * @param y the y coordinate of the upper-left corner of the Text
     * @param font the font of the text to be displayed
     * @param color the color of the text to be displayed
     */
    public static void text(String str, int x, int y, Font font, Color color) {
        Display.displayItems.add(new Text(str,x,y,color,font));
    }

    /**
     * Draws the Text.
     * @param text the Text to be displayed
     */
    public static void text(Text text) {
        Display.displayItems.add(text);
    }

    /**
     * Draws the Text at the specified coordinate.
     * @param text the Text to be displayed
     * @param x the x coordinate of the upper-left corner of the Text
     * @param y the y coordinate of the upper-left corner of the Text
     */
    public static void text(Text text, int x, int y) {
        text.setLocation(x, y);
        Display.displayItems.add(text);
    }

    /**
     * Set a color to be the default color for drawing shapes with no specified color.
     * @param c the color to be set as the graphics color
     */
    public static void setColor(jagame.Color c) {
        color = c;
    }
}
