package jagame;
import jagame.graphics.Image;

import javax.swing.*;
import java.awt.Graphics2D;

/**
 * This class represents a Button object
 *
 * @version January 2024
 * @author  Vivian Ji
 * @author  Anastasiya Volgina
 * @author  Claire Guo
 * @see     Mouse
 */

public class Button {
    private int x, y, width, height;
    private Color beforeColor, afterColor;
    private String text;
    private Image beforeImage, afterImage;
    protected boolean disabled = false;

    /**
     * Constructs a Button object
     * @param x The x coordinate of the button
     * @param y The y coordinate of the button
     * @param width The width of the button
     * @param height The height of the button
     */
    private Button(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructs a Button object
     * @param x The x coordinate of the button
     * @param y The y coordinate of the button
     * @param width The width of the button
     * @param height The height of the button
     * @param beforeColor The color of the button before it was pressed
     * @param afterColor The color of the button after it has been pressed
     */
    public Button(int x, int y, int width, int height, Color beforeColor, Color afterColor){
        this(x,y,width,height);
        this.beforeColor = beforeColor;
        this.afterColor = afterColor;
    }

    /**
     * Constructs a Button object
     * @param x The x coordinate of the button
     * @param y The y coordinate of the button
     * @param width The width of the button
     * @param height The height of the button
     * @param beforeImage The image of the button before it was pressed
     * @param afterImage The image of the button after it was pressed
     */
    public Button(int x, int y, int width, int height, Image beforeImage, Image afterImage){
        this(x,y,width,height);
        this.beforeImage = beforeImage;
        this.afterImage = afterImage;
    }

    /**
     * Constructs a Button object
     * @param x The x coordinate of the button
     * @param y The y coordinate of the button
     * @param width The width of the button
     * @param height The height of the button
     * @param text The text on the button
     */
    public Button(int x, int y, int width, int height, String text){
        this(x,y,width,height);
        this.text = text;
    }

    /**
     * Constructs a Button object
     * @param x The x coordinate of the button
     * @param y The y coordinate of the button
     * @param width The width of the button
     * @param height The height of the button
     * @param beforeColor The color of the button before it was pressed
     * @param afterColor The color of the button after it has been pressed
     * @param text The text on the button
     */
    public Button(int x, int y, int width, int height, Color beforeColor, Color afterColor, String text){
        this(x,y,width,height);
        this.beforeColor = beforeColor;
        this.afterColor = afterColor;
        this.text = text;
    }

    /**
     * Checks if the button has been pressed
     * @return <code>true</code> if the button has been pressed
     *         <code>false</code> if the button has not been pressed
     */
    public boolean isPressed(){
        return !disabled && Mouse.isPressed(1) && isHovered();
    }

    /**
     * Checks if the button is being hovered
     * @return <code>true</code> if the button is being hovered
     *         <code>false</code> if the button is not being hovered
     */
    private boolean isHovered(){
        return Mouse.getMouseLocation().x > this.x && Mouse.getMouseLocation().y > this.y &&
                Mouse.getMouseLocation().x < this.x + this.width && Mouse.getMouseLocation().y < this.y + this.height;
    }

    /**
     * Sets the button visibility
     * @param visible If the button is to be visible or not
     */
    public void setVisible(boolean visible){
        if (visible) {
            if (!Display.buttons.contains(this)) {
                Display.addButton(this);
            }
            this.disabled = false;
        } else {
            Display.removeButton(this);
            this.disabled = true;
        }
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getWidth(){return this.width;}
    public int getHeight(){return this.height;}
    public void setBeforeColor(Color c){
        this.beforeColor = c;
    }
    public void setAfterColor(Color c){
        this.afterColor = c;
    }
    public void setText(String text){
        this.text = text;
    }
    public void setBeforeImage(Image img){
        this.beforeImage = img;
    }
    public void setAfterImage(Image img){
        this.afterImage = img;
    }
    public Color getBeforeColor(){
        return this.beforeColor;
    }
    public Color getAfterColor(){
        return this.afterColor;
    }
    public String getText(){
        return this.text;
    }
    public Image getBeforeImage(){
        return this.beforeImage;
    }

    public Image getAfterImage() {
        return afterImage;
    }

    /**
     * Sets if button is disabled
     * @param disabled If the button has been disabled
     */
    public void isDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * paintComponent
     * @param g2d the <code>Graphics2D</code> object which allows for visual display
     */
    public void draw(Graphics2D g2d){
        if(!this.isHovered()){
            if(beforeColor!=null){
                g2d.setColor(beforeColor);
                g2d.fillRoundRect(this.x, this.y, this.width, this.height, this.width/4, this.height/4);
                if(text!=null){
                    g2d.setColor(Color.black);
                    g2d.drawString(text, (this.x+this.width/2)-g2d.getFontMetrics().stringWidth(text)/2, (this.y+this.height/2));
                }
            }else{
                g2d.drawImage(beforeImage.getImage(), this.x, this.y, this.width, this.height, null);
            }
        }else{
            if(afterColor!=null){
                g2d.setColor(afterColor);
                g2d.fillRoundRect(this.x, this.y, this.width, this.height, this.width/4, this.height/4);
                if(text!=null){
                    g2d.setColor(Color.black);
                    g2d.drawString(text, (this.x+this.width/2)-g2d.getFontMetrics().stringWidth(text)/2, (this.y+this.height/2));
                }
            }else{
                g2d.drawImage(afterImage.getImage(), this.x, this.y, this.width, this.height, null);
            }
        }
    }
}
