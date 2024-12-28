package jagame;

import jagame.graphics.DisplayItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is used to control the display screen
 *
 * @version January 2024
 * @author  Vivian Ji
 * @author  Anastasiya Volgina
 * @author  Claire Guo
 * @see     JFrame
 * @see     JPanel
 */

public class Display {

    protected static JFrame frame;
    protected static GraphicsPanel panel;

    protected static volatile Queue<DisplayItem> displayItems = new LinkedList<>();
    protected static volatile ArrayList<Button> buttons = new ArrayList<>();

    protected final static Object synchObject = new Object();
    protected static boolean paused = false;

    /**
     * Private Constructor
     */
    private Display() {}

    /**
     * Initializes a new display window
     */
    public static void init() {
        frame = new JFrame();
        panel = new GraphicsPanel();
        panel.setLayout(null);
        //frame.getContentPane().add(panel);
        frame.add(panel);

        frame.setIconImage(new ImageIcon("src/pic.png").getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Time.setRepaintTimer();
    }

    /**
     * Initializes a new display window with a title
     * @param title String representing the title
     */
    public static void init(String title) {
        Display.init();
        Display.setTitle(title);
    }

    /**
     * Initializes a new display with a customized width and height
     * @param width The width of the frame
     * @param height The height of the frame
     */
    public static void init(int width, int height) {
        Display.init();
        Display.setWindowSize(width, height);
    }

    /**
     * Initializes a new display with a customized title, width, and height
     * @param title String representing the title
     * @param width The width of the frame
     * @param height The height of the frame
     */
    public static void init(String title, int width, int height) {
        Display.init(title);
        Display.setWindowSize(width, height);
    }

    /**
     * Initializes and sets up the MouseListener and MouseMotionListener
     */
    protected static void initMouse(){
        panel.addMouseListener(new Mouse.mouseHidden());
        panel.addMouseMotionListener(new Mouse.mouseHidden());
    }

    /**
     * Initializes and sets up the KeyboardListener
     */
    protected static void initKeyboard(){
        frame.addKeyListener(new Keyboard.keyboardHidden());
    }

    /**
     * Quit the frame
     */
    public static void quit() {
        System.exit(0);
    }

    /**
     * Sets the title of the JFrame
     * @param title
     */
    public static void setTitle(String title) {
        frame.setTitle(title);
    }

    /**
     * Sets a new frame size
     * @param width The new width of the JFrame
     * @param height The new height of the JFrame
     */
    public static void setWindowSize(int width, int height) {
        frame.setSize(width, height);
    }

    /**
     * Centers the JFrame on your screen
     */
    public static void centreFrameInWindow(){
        frame.setLocationRelativeTo(null);
    }

    /**
     * Sets the size of the JFrame
     * @param width The width of the JFrame
     * @param height The height of the JFrame
     */
    public static void setDisplaySize(int width, int height) {
        panel.setPreferredSize(new Dimension(width, height));
        frame.pack();
    }

    /**
     * Shows the JFrame
     */
    public static void show() {
        frame.setVisible(true);
    }

    /**
     * Hides the JFrame
     */
    public static void hide() {
        frame.setVisible(false);
    }

    /**
     * Removes the JFrame title bar
     */
    public static void removeTitleBar(){ //Exception in thread "main" java.awt.IllegalComponentStateException: The frame is displayable.
        if(!frame.isUndecorated()) {
            frame.setUndecorated(true);
        }
        frame.setVisible(true);
    }

    public static ArrayList<Button> getButtons () {
        return buttons;
    }

    /**
     * Sleeps the thread for a certain amount of time
     * @param time The amount of time in ms to sleep the thread for
     */
    public static void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the background color of window.
     * @param color the color of the background
     */
    public static void setBackground(jagame.Color color) {
        panel.setBackground(color);
    }

    /**
     * Refreshes the screen at a default framerate
     */
    public static void refresh() {
//        System.out.println("waiting");
        paused = false;
//        System.out.println("paused = " + paused);
        Time.repaintTime = Time.lastFrameTime + Const.DEFAULT_FRAMERATE;
        while (System.currentTimeMillis() < Time.repaintTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        panel.repaint();

        try{
            synchronized (synchObject){
                synchObject.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Refreshes the screen at the default frame rate with a specified colour
     * @param c The colour to repaint the screen with
     */
    public static void refresh(Color c) {
        Time.repaintTime = Time.lastFrameTime + Const.DEFAULT_FRAMERATE;
        while (System.currentTimeMillis() < Time.repaintTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        panel.repaint();
        panel.setBackground(c);

        try{
            synchronized (synchObject){
                synchObject.wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Refreshes the screen at a specific frame rate
     * @param framerate The frame rate to refresh at
     */
    public static void refresh(int framerate) {
        Time.repaintTime = Time.lastFrameTime + 1000/framerate;
        while (System.currentTimeMillis() < Time.repaintTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        panel.repaint();

        try{
            synchronized (synchObject){
                synchObject.wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Refreshes and repaints the screen with a specific colour and frame rate
     * @param c The colour to paint the screen
     * @param framerate The frame rate to refresh at
     */
    public static void refresh(Color c, int framerate) {
        Time.repaintTime = Time.lastFrameTime + 1000/framerate;
        while (System.currentTimeMillis() < Time.repaintTime) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        panel.repaint();
        panel.setBackground(c);

        try {
            synchronized (synchObject){
                synchObject.wait();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Protected method which sets the cursor image
     * @param filePath A String with the image file path
     * @param width The new width of the cursor image
     * @param height The height of the cursor image
     */
    protected static void setCursor(String filePath, int width, int height){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage(filePath);

        Image image = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);


        Cursor c = toolkit.createCustomCursor(image , new Point(panel.getX(), panel.getY()), "img");
        panel.setCursor (c);

    }

    /**
     * Protected method which sets the cursor image
     * @param filePath A String with the image file path
     */
    protected static void setCursor(String filePath){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage(filePath);
        Cursor c = toolkit.createCustomCursor(img , new Point(panel.getX(), panel.getY()), "img");
        panel.setCursor (c);
    }

    /**
     * Removes a button from the screen
     * @param b The button to be removed
     */
    public static void removeButton(Button b){
        buttons.remove(b);
        b.isDisabled(true);
    }

    /**
     * Adds a new button to the screen using an existing button object
     * @param b The button to be added
     */
    public static void addButton(Button b){
        buttons.add(b);
        b.isDisabled(false);
    }

    /**
     * Adds a new button
     * @param x The x location of the button
     * @param y The y location of the button
     * @param width The width of the button
     * @param height The height of the button
     * @param beforeColor The colour of the button before it has been pressed
     * @param afterColor The colour of the button after it has been pressed
     * @return A reference for the button object created
     */
    public static Button addButton(int x, int y, int width, int height, jagame.Color beforeColor, jagame.Color afterColor){
        Button b = new Button(x,y,width,height,beforeColor,afterColor);
        addButton(b);
        return b;
    }

    /**
     * Adds a progress bar to the Display
     * @param x progress bar's x coordinate
     * @param y progress bar's y coordinate
     * @param width progress bar's width
     * @param height progress bar's height
     * @param orientation progress bar's orientation (vertical or horizontal)
     * @param max max value
     * @param fg color of foreground bar
     * @param bg color of background bar
     * @param font color of font
     * @return the progress bar
     */
    public static ProgressBar addProgressBar(int x, int y, int width, int height, int orientation, int max, Color fg, Color bg, Color font) {
        ProgressBar bar = new ProgressBar(x, y, width, height, orientation, max, fg, bg, font);
        panel.add(bar.getCustomizedProgressBar());
        return bar;
    }

    /**
     * Adds a progress bar to the Display
     * @param x progress bar's x coordinate
     * @param y progress bar's y coordinate
     * @param width progress bar's width
     * @param height progress bar's height
     * @param orientation progress bar's orientation (vertical or horizontal)
     * @param max max value
     * @return the progress bar
     */
    public static ProgressBar addProgressBar(int x, int y, int width, int height, int orientation, int max) {
        ProgressBar bar = new ProgressBar(x, y, width, height, orientation, max);
        panel.add(bar.getCustomizedProgressBar());
        return bar;
    }

    /**
     * Adds a progress bar to the Display
     * @param bar The ProgressBar to be added
     * @return Returns the added ProgressBar
     */
    public static ProgressBar addProgressBar(ProgressBar bar) {
        panel.add(bar.getCustomizedProgressBar());
        return bar;
    }

    /**
     * GraphicsPanel inner class extending JPanel
     */
    static class GraphicsPanel extends JPanel {
        /**
         * Override Graphics PaintComponent
         * @param g the <code>Graphics</code> object which allows for displays
         */
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            while (!displayItems.isEmpty()) {
                DisplayItem item = displayItems.poll();
                g2d.setColor(item.getColor());
                item.draw(g2d);
            }

            buttons.forEach(button -> button.draw(g2d));

            Time.update();

            paused = true;
            synchronized (synchObject){
                synchObject.notifyAll();
            }
        }

        public void notifying() {
            synchronized (synchObject) {
                synchObject.notify();
            }
        }
    }
}