package jagame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Class that reads keyboard input
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see KeyListener
 */

public class Keyboard {
    /**
     * Private constructor
     */
    private Keyboard(){
    }
    protected static Queue<Character> keyInput = new LinkedList<Character>();

    protected static Set<Character> keyPressed = new HashSet<>();

    /**
     * Adds keyboard listener to the JPanel
     */
    public static void init(){
        Display.initKeyboard();
    }

    /**
     * Checks which key has been typed
     * @return <code>Character</code> which key has been typed
     */
    public static Character getKeyTyped() {
        return keyInput.poll();
    }

    /**
     * Checks if the key has been pressed
     * @return <code>true</code> if the character has been pressed
     *         <code>false</code> if the character has not been pressed
     */
    public static boolean isPressed(char c) {
        return keyPressed.contains(c);
    }

    /**
     * Inner class which reads key input
     */
    protected static class keyboardHidden implements KeyListener {
        /**
         * Instantiates a hidden keyboard listener, adds KeyListener to the JPanel
         */
        protected keyboardHidden(){
            Display.panel.addKeyListener(this);
        }

        /**
         * Adds key that has been typed
         * @param e Uses KeyEvent
         * @see KeyListener
         */
        @Override
        public void keyTyped(KeyEvent e) { //*****arrows only work for pressed, not typed******
            keyInput.add(e.getKeyChar());
        }

        /**
         * Adds key that has been pressed
         * @param e Uses KeyEvent
         * @see KeyListener
         */
        @Override
        public void keyPressed(KeyEvent e) {
            keyPressed.add(e.getKeyChar());
        }

        /**
         * Removes key that is no longer pressed
         * @param e Uses KeyEvent
         * @see KeyListener
         */
        @Override
        public void keyReleased(KeyEvent e) {
            keyPressed.remove(e.getKeyChar());
        }
    }
}