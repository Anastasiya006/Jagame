package jagame.graphics;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Rectangle;
import java.awt.Point;

/**
 * This class represents an image. Object of this class can be drawn onto the display. Collision can be detected
 * between 2 images.
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see jagame.graphics.DisplayItem
 * @see java.awt.image.BufferedImage
 * @see java.awt.Rectangle
 */
public class Image extends DisplayItem {

    /**
     * The image to be drawn.
     */
    private BufferedImage image;

    private int width, height;

    /**
     * The awt.Rectangle of the image bound if image is not rotated
     */
    private Rectangle rect;

    /**
     * The rotation angle of image. A positive rotation angle turns the image in clockwise direction.
     */
    private int rotation = 0;

    /**
     * Constructs an image whose has the passed bufferedImage, whose upper-left corner is at (0, 0).
     * @param image the bufferedImage of Image
     */
    public Image(BufferedImage image) {
        this(image, 0, 0);
    }

    /**
     * Constructs an image whose has the passed bufferedImage, whose upper-left corner is at (x, y).
     * @param image the bufferedImage of Image
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     */
    public Image(BufferedImage image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.rect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    /**
     * Constructs an image whose read the image at provided path, whose upper-left corner is at (0, 0).
     * @param fileName the path of image to be read
     */
    public Image(String fileName) {
        this(fileName, 0, 0);
    }

    /**
     * Constructs an image whose read the image at provided path, whose upper-left corner is at (x, y).
     * @param fileName the path of image to be read
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     */
    public Image(String fileName, int x, int y) {
        try {
            image = ImageIO.read(new File(fileName));
            this.x = x;
            this.y = y;
            this.rect = new Rectangle(x, y, image.getWidth(), image.getHeight());
            this.width = image.getWidth();
            this.height = image.getHeight();
        } catch (IOException e) {
            System.err.println("File not found at provided location.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("File not found at provided location.");
        }
    }

    /**
     * Constructs an image, initialized to match the values of the specified Image, whose upper-left corner
     * is at (x, y).
     * @param image the Image from which to copy initial values to a new Image
     * @param x the specified x coordinate
     * @param y the specified y coordinate
     */
    public Image(Image image, int x, int y) {
        this.image = image.image;
        this.x = x;
        this.y = y;
        this.rect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }
    public int getRotation(){
        return this.rotation;
    }
    public BufferedImage getImage() {
        return this.image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Crops the image from (0, 0) to (width, height) on the coordinate system of image.
     * @param width the width of cropped image
     * @param height the height of cropped image
     */
    public void cropImage(int width, int height) {
        BufferedImage dest = this.image.getSubimage(0, 0, width, height);
        this.image = dest;
        this.rect.setSize(width, height);
    }

    /**
     * Crops the image from (width1, height1) to (width2, height2) on the coordinate system of image.
     * @param width1 the upper-left x coordinate of cropped image on the coordinate system of un-cropped image
     * @param height1 the upper-left y coordinate of cropped image on the coordinate system of un-cropped image
     * @param width2 the lower-right x coordinate of cropped image on the coordinate system of un-cropped image
     * @param height2 the lower-right y coordinate of cropped image on the coordinate system of un-cropped image
     */
    public void cropImage(int width1, int height1, int width2, int height2) {
        BufferedImage dest = this.image.getSubimage(width1, height1, width2, height2);
        this.image = dest;
        this.rect.setSize(width2-width1, height2-height1);
    }

    /**
     * Sets the size of image.
     * @param width the width of the image
     * @param height the height of the arc
     */
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.rect.width = width;
        this.rect.height = height;
    }

    /**
     * Sets the location of image.
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.rect.x = x;
        this.rect.y = y;
    }

    /**
     * Translate the location of image.
     * @param dx the change in x coordinate
     * @param dy the change in y coordinate
     */
    @Override
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

    /**
     * Determines whether this image collides with another image. This method accounts for rotated image's collision.
     * @param other the other image to determine whether there is collision
     * @return a boolean that indicates whether there is collision between the images
     */
    public boolean collide(Image other){
        return this.collideOther(other)||other.collideOther(this);
    }
    private boolean collideOther(Image other){
        if((rotation%180==0)&&(other.rotation%180==0)) {
            return other.rect.intersects(this.rect);
        }

        Point[]oldPoints = {new Point(x,y), new Point(x+width, y), new Point(x+width, y+height), new Point(x,y+height)};
        Point[]newPoints = new Point[4];
        Point centre = new Point(x+width/2, y+height/2);

        for(int i=0; i<oldPoints.length; i++){
            Point newPoint = new Point();
            Point oldPoint = oldPoints[i];

            newPoint.x=(int)Math.round((oldPoint.x-centre.x)*Math.cos(Math.toRadians(rotation))-(oldPoint.y-centre.y)*Math.sin(Math.toRadians(rotation)))+centre.x;
            newPoint.y=(int)Math.round((oldPoint.y-centre.y)*Math.cos(Math.toRadians(rotation))+(oldPoint.x-centre.x)*Math.sin(Math.toRadians(rotation)))+centre.y;

            newPoints[i]=newPoint;
        }

        Line2D.Double[]newLines = new Line2D.Double[]{new Line2D.Double(newPoints[0], newPoints[1]), new Line2D.Double(newPoints[1], newPoints[2]), new Line2D.Double(newPoints[2], newPoints[3]), new Line2D.Double(newPoints[3], newPoints[0])};

        if(other.rotation!=0) {
            Point[] oldPointsOther = {new Point(other.x, other.y), new Point(other.x + other.width, other.y), new Point(other.x + other.width, other.y + other.height), new Point(other.x, other.y + other.height)};
            Point[] newPointsOther = new Point[4];
            Point centreOther = new Point(other.x + other.width / 2, other.y + other.height / 2);

            for (int i = 0; i < oldPoints.length; i++) {
                Point newPoint = new Point();
                Point oldPoint = oldPointsOther[i];

                newPoint.x = (int) Math.round((oldPoint.x - centre.x) * Math.cos(Math.toRadians(other.rotation)) - (oldPoint.y - centre.y) * Math.sin(Math.toRadians(other.rotation))) + centreOther.x;
                newPoint.y = (int) Math.round((oldPoint.y - centre.y) * Math.cos(Math.toRadians(other.rotation)) + (oldPoint.x - centre.x) * Math.sin(Math.toRadians(other.rotation))) + centreOther.y;

                newPointsOther[i] = newPoint;
            }

            Line2D.Double[]newLinesOther = new Line2D.Double[]{new Line2D.Double(newPointsOther[0], newPointsOther[1]), new Line2D.Double(newPointsOther[1], newPointsOther[2]), new Line2D.Double(newPointsOther[2], newPointsOther[3]), new Line2D.Double(newPointsOther[3], newPointsOther[0])};

            for (Line2D.Double newLineOther : newLinesOther) {
                for (Line2D.Double newLine : newLines) {
                    if (newLine.intersectsLine(newLineOther)) {
                        return true;
                    }
                }
            }
            return false;

        }else{
            if(newLines[0].intersects(other.rect)||newLines[1].intersects(other.rect)||newLines[2].intersects(other.rect)||newLines[3].intersects(other.rect)){
                return true;
            }
            return false;
        }
    }

    /**
     * Set the rotation angle of image.
     * @param rotation the angle of image
     */
    public void rotate(int rotation) {
        this.rotation = rotation;
    }

    /**
     * Draws the image on display according to its rotation.
     * @param g2d the graphics to paint on
     */
    @Override
    public void draw(Graphics2D g2d) {
        if (rotation != 0) {
            double radianRotate = Math.toRadians(rotation);

            g2d.translate(x + width/2,y + height/2);

            g2d.rotate(radianRotate);

            g2d.drawImage(image, -width/2, -height/2,width, height, null);

            g2d.rotate(-1* radianRotate);
            g2d.translate(-(x+ width/2), -(y+ height/2));
        } else {
            g2d.drawImage(image, x, y, width, height,null);
        }
    }
}
