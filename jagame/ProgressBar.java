package jagame;

import javax.swing.*;
import java.awt.*;

/**
 * Class that represents Progress Bar object
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see JProgressBar
 */

public class ProgressBar {

    public static final int VERTICAL_ORIENTATION = 1;
    public static final int HORIZONTAL_ORIENTATION = 0;
    private final customizedProgressBar customizedProgressBar;

    /**
     * Constructs a ProgressBar
     * @param x x position of the progress bar
     * @param y y position of the progress bar
     * @param width width of the progress bar
     * @param height height of the progress bar
     * @param orientation orientation of the progress bar
     * @param max maximum value of the progress bar
     */
    public ProgressBar(int x, int y, int width, int height, int orientation, int max) {
        customizedProgressBar = new customizedProgressBar(x, y, width, height, orientation, max);
    }

    /**
     * Constructs a ProgressBar
     * @param x x position of the progress bar
     * @param y y position of the progress bar
     * @param width width of the progress bar
     * @param height height of the progress bar
     * @param orientation orientation of the progress bar
     * @param max maximum value of the progress bar
     * @param fg Foreground colour of the progress bar
     * @param bg Background colour of the progress bar
     * @param font Font representing progress value on the progress bar
     */
    public ProgressBar(int x, int y, int width, int height, int orientation, int max, Color fg, Color bg, Color font) {
        customizedProgressBar = new customizedProgressBar(x, y, width, height, orientation, max, fg, bg, font);
    }

    protected customizedProgressBar getCustomizedProgressBar() {
        return this.customizedProgressBar;
    }

    /**
     * Sets the location
     * @param x x coordinate
     * @param y y coordinate
     */
    public void setLocation(int x, int y) {
        customizedProgressBar.setLocation(x, y);
    }

    /**
     * Sets the size
     * @param width width of progress bar
     * @param height height of progress bar
     */
    public void setSize(int width, int height) {
        customizedProgressBar.setSize(width, height);
    }

    public void enableText(boolean state) {
        customizedProgressBar.enableText(state);
    }

    /**
     * Sets the foreground color
     * @param color foreground color
     */
    public void setForegroundColor(Color color) {
        customizedProgressBar.setForegroundColor(color);
    }

    /**
     * Sets the background color
     * @param color background color
     */
    public void setBackgroundColor(Color color) {
        customizedProgressBar.setBackgroundColor(color);
    }

    /**
     * Sets the font color
     * @param color font color
     */
    public void setFontColor(Color color) {
        customizedProgressBar.setFontColor(color);
    }

    /**
     * Updates the progress value
     * @param value current progress value
     */
    public void updateValue(int value) {
        customizedProgressBar.setValue(value);
    }

    /**
     * Returns the current progress value
     * @return an int of the value
     */
    public int getValue() {
        return customizedProgressBar.getValue();
    }

    /**
     * Returns the percent completed
     * @return a double of the percent completed
     */
    public double getPercentComplete() {
        return customizedProgressBar.getPercentComplete();
    }

    private static class customizedProgressBar extends JProgressBar {
        private static Color foregroundColor;
        private static Color backgroundColor;
        private static Color fontColor;
        private static boolean text;
        private int value;
        Font font;

        /**
         * Constructs a customized JProgressBar
         * @param x x position of the progress bar
         * @param y y position of the progress bar
         * @param width width of the progress bar
         * @param height height of the progress bar
         * @param orientation orientation of the progress bar
         * @param max maximum value of the progress bar
         */
        private customizedProgressBar(int x, int y, int width, int height, int orientation, int max) {
            this.setBounds(x, y, width, height);
            this.setOrientation(orientation);
            this.setMaximum(max);
            this.setBackground(new Color(0, 0, 0, 0));
            this.setForeground(new Color(0, 0, 0, 0));

            foregroundColor = new Color(161, 207, 247);
            backgroundColor = new Color(220, 224, 227);
            fontColor = new Color(27, 104, 161);
        }

        /**
         * Constructs a customized JProgressBar
         * @param x x position of the progress bar
         * @param y y position of the progress bar
         * @param width width of the progress bar
         * @param height height of the progress bar
         * @param orientation orientation of the progress bar
         * @param max maximum value of the progress bar
         * @param fg Foreground colour of the progress bar
         * @param bg Background colour of the progress bar
         * @param font Font representing progress value on the progress bar
         */
        private customizedProgressBar(int x, int y, int width, int height, int orientation, int max, Color fg, Color bg, Color font) {
            this(x, y, width, height, orientation, max);

            foregroundColor = fg;
            backgroundColor = bg;
            fontColor = font;
        }

        /**
         * Sets the progress out of the maximum
         * @param value the new updated value
         */
        public void setValue(int value) {
            if (this.getMaximum() >= value) {
                this.value = value;
            }
        }

        public int getValue() {
            return this.value;
        }

        public void setForegroundColor(Color color) {
            foregroundColor = color;
        }

        public void setBackgroundColor(Color color) {
            backgroundColor = color;
        }

        public void setFontColor(Color color) {
            fontColor = color;
        }

        public void enableText(boolean state) {
            text = state;
        }

        /**
         * paintComponent
         * @param g the <code>Graphics</code> object which allows for visual displays
         */
        @Override
        protected void paintComponent(Graphics g) {
            String percent = ((double)this.value / (double)this.getMaximum()) * 100 + "%";

            if (this.getOrientation() == HORIZONTAL) { //horizontal orientation
                int foregroundWidth = (int)(this.getWidth() * ((double)this.value / (double)this.getMaximum()));

                font = new Font ("Nunito", Font.PLAIN, this.getHeight() / 2);
                g.setFont(font);

                g.setColor(backgroundColor);
                g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), Const.BORDER, Const.BORDER);

                g.setColor(foregroundColor);
                g.fillRoundRect(0, 0, foregroundWidth, this.getHeight(), Const.BORDER, Const.BORDER);
            } else { //vertical orientation
                int foregroundHeight = (int)(this.getHeight() * ((double)this.value / (double)this.getMaximum()));

                font = new Font ("Nunito", Font.PLAIN, this.getWidth() / percent.length());
                g.setFont(font);

                g.setColor(backgroundColor);
                g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), Const.BORDER, Const.BORDER);

                g.setColor(foregroundColor);
                g.fillRoundRect(0, 0, this.getWidth(), foregroundHeight, Const.BORDER, Const.BORDER);
            }

            if (text) {
                g.setColor(fontColor);
                //center Text in the middle of the progress bar
                g.drawString(percent, (this.getWidth() - g.getFontMetrics().stringWidth(percent))/2,
                        (this.getHeight()/2 + font.getSize()/2));
            }
        }
    }
}