package jagame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

/**
 * Class that plays audio files
 * @author Claire Guo
 * @author Vivian Ji
 * @author Anastasiya Volgina
 * @version January 2024
 * @see javax.sound.sampled
 */

public class Mixer {

    /**
     * Private constructor
     */
    private Mixer() {}

    /**
     * Adds an Audio to the Mixer
     * @param file Audio file
     * @return an instance of the added Audio
     */
    public static Audio addAudio(File file) {
        return new Audio(file);
    }

    public static class Audio {
        private final File file;
        private Clip clip;
        private int framePosition;

        private Audio(File file) {
            this.file = file;
        }

        /**
         * Plays the Audio an indicated number of times
         */
        public void play(int times) {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.setFramePosition(framePosition);
                if (times == -1) {
                    clip.loop(times);
                } else {
                    clip.loop(times-1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * Plays the Audio infinitely
         */
        public void loop() {
            play(Clip.LOOP_CONTINUOUSLY);
        }

        /**
         * Pauses the Audio, position is saved
         */
        public void pause() {
            framePosition = clip.getFramePosition();
            clip.close();
        }

        /**
         * Stops the Audio, position is not saved
         */
        public void stop() {
            clip.close();
        }

        /**
         * Resets the Audio back to the start
         */
        public void reset() {
            clip.setFramePosition(0); //sets back to the beginning
        }

        /**
         * Changes the volume of the Audio
         * @param volume volume of the Audio
         */
        public void setVolume(double volume) {
            if (volume >= 0 && volume <= 1.0) { //based on a linear scale (0.0 --> 1.0)
                FloatControl volumeController = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                volumeController.setValue((20f * (float) Math.log10(volume))); //convert volume into decibels
            }
        }
    }
}