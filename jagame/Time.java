package jagame;

import javax.swing.*;
import java.util.LinkedList;

/**
 * Class that reads time information
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see Timer
 */

public class Time {

    protected static long startTime;
    protected static long lastFrameTime;
    protected static long repaintTime;
    protected static Timer timer;
    protected static LinkedList<Long> intervals = new LinkedList<>();
    protected static double average;

    /**
     * Private Constructor
     */
    private Time() {}

    /**
     * Starts the timer
     */
    public static void start() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Gets the time elapsed
     * @return <code>long</code> The current time elapsed in ms
     */
    public static long getElapsedTime() {
        if (Display.frame == null) {
            return 0;
        } else {
            return System.currentTimeMillis() - startTime;
        }
    }

    /**
     * Updates and counts frame time
     */
    protected static void update() {
        if (lastFrameTime != 0) {
            repaintTime = System.currentTimeMillis();
            if (intervals.size() == 10) {
                average = (average * 10 - intervals.removeFirst() - lastFrameTime + repaintTime) / 10.0;
            } else {
                average = (average * intervals.size() + repaintTime - lastFrameTime)/ (intervals.size() + 1.0);
            }
            intervals.add(repaintTime - lastFrameTime);
            lastFrameTime = repaintTime;
        } else {
            lastFrameTime = System.currentTimeMillis();
        }
    }

    public static int getFPS() {
        return (int) (1000/average);
    }

    /**
     * Sets the repaint timer
     */
    protected static void setRepaintTimer() {
        timer = new Timer(50, e -> {

            if (Display.paused) {
                Display.panel.notifying();

            }
        });
        timer.start();
    }
}
