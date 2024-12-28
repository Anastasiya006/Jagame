package jagame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class that reads mouse input
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see MouseListener
 * @see MouseMotionListener
 */

public class Mouse {

    /**
     * Private constructor
     */
    private Mouse(){
    }
    protected static Queue<Point> click = new LinkedList<>();
    protected static boolean[] buttonPressed = new boolean[17];
    protected static Point mouseLocation = new Point();
    public static int LEFT_CLICK = 1;
    public static int RIGHT_CLICK = 2;

    /**
     * Adds the MouseListener to the JFrame
     */
    public static void init(){
        Display.initMouse();
    }

    /**
     * Checks to see if a certain button is clicked on the mouse
     * @param button This takes the button that will be checked if it's pressed or not
     * @return <code>true</code> if the mouse button has been pressed
     *         <code>false</code> if the mouse button has not been pressed
     */
    public static boolean isPressed(int button){
        return buttonPressed[button];
    }

    /**
     * Checks to see where the mouse last clicked
     * @return <code>Point</code> at which the mouse was clicked
     *         <code>null</code> if the mouse has not been clicked
     */
    public static Point getButtonClicked(){
        return click.poll();
    }

    /**
     * Returns where the mouse is relative to the JPanel
     * @return <code>Point</code> at which the mouse is
     */
    public static Point getMouseLocation(){
        return mouseLocation;
    }

    /**
     * Sets the cursor image
     * @param filePath Takes in the image file path to be set as the cursor
     */
    public static void setCursor(String filePath){
        Display.setCursor(filePath);
    }

    /**
     * Sets the cursor image including a width and height
     * @param filePath Takes in the image file path to be set as the cursor
     * @param width The new width of the cursor image
     * @param height The new height of the cursor image
     */
    public static void setCursor(String filePath, int width, int height){
        Display.setCursor(filePath, width, height);
    }

    /**
     * Inner class which implements MouseListener and MouseMotionListener to read mouse movement
     */
    protected static class mouseHidden implements MouseListener, MouseMotionListener {

        /**
         * Inherited from MouseListener
         * Checks for mouse click
         * @param e Uses MouseEvent
         * @see MouseListener
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            click.add(e.getPoint());
        }

        /**
         * Inherited from MouseListener
         * Checks which mouse button has been pressed
         * @param e Uses MouseEvent
         * @see MouseListener
         */
        @Override
        public void mousePressed(MouseEvent e) {
            buttonPressed[e.getButton()] = true;
        }

        /**
         * Inherited from MouseListener
         * Checks if the mouse button has been released
         * @param e Uses MouseEvent
         * @see MouseListener
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            buttonPressed[e.getButton()] = false;
        }

        /**
         * Inherited from MouseListener
         * Checks if the mouse button has entered
         * @param e Uses MouseEvent
         * @see MouseListener
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            return;
        }

        /**
         * Inherited from MouseListener
         * Checks if the mouse has exited
         * @param e Uses MouseEvent
         * @see MouseListener
         */
        @Override
        public void mouseExited(MouseEvent e) {
            return;
        }

        /**
         * Inherited from MouseMotionListener
         * Checks if the mouse is being dragged
         * @param e Uses MouseEvent
         * @see MouseMotionListener
         */
        @Override
        public void mouseDragged(MouseEvent e) {
            buttonPressed[e.getButton()] = true;
        }

        /**
         * Inherited from MouseMotionListener
         * Checks if the mouse has been moved
         * @param e Uses MouseEvent
         * @see MouseMotionListener
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            mouseLocation = e.getPoint();
        }
    }
}
