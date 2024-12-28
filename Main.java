import jagame.*;
import jagame.graphics.*;
import jagame.Mixer.*;

import java.io.File;
import java.util.ArrayList;

public class Main {

    static final int FRAME_WIDTH = 500;
    static final int FRAME_HEIGHT = 650;
    static final int SCROLL = 2;

    static final int PIPE_WIDTH = 90;
    static final int PIPE_DISTANCE = (int)(PIPE_WIDTH * 2.5);

    static final int BIRD_VY = 8;
    static final int GRAVITY = 2;

    static final int BIRD_START_Y = 250;

    static int score = 0;

    static Image[] bgImages = new Image[2];
    static Image bird;
    static Audio ping;
    static Button play, reset, quit;

    //screens
    static boolean titleScreen = true;
    static boolean gameScreen = false;
    static boolean gameOverScreen = false;

    //pipes
    static ArrayList<Image> pipes = new ArrayList<>();
    static ArrayList<Image> pastPipes = new ArrayList<>();

    //font
    static Font font = new Font("Nunito", Font.PLAIN, 50);

    public static void main(String[] args) {

        setup();

        //game
        while (true) {
            if (titleScreen) {
                Draw.image("src/demo/title-screen.png", 0, 0);
                Draw.image(bird);

                bird.rotate(bird.getRotation() + 5);

                if (play.isPressed()) {
                    Display.removeButton(play);
                    bird.rotate(0);
                    gameScreen = true;
                    titleScreen = false;
                    Display.wait(100);
                }
            } else if (gameScreen) {
                inGame();
            } else if (gameOverScreen) {
                Draw.image("src/demo/game-over-screen.png", 0, 0);

                Draw.text(String.valueOf(score), 230, 205, font);

                if (quit.isPressed()) {
                    Display.quit();
                } else if (reset.isPressed()) {
                    pastPipes = new ArrayList<>();
                    pipes = new ArrayList<>();
                    gameOverScreen = false;
                    titleScreen = true;
                    quit.setVisible(false);
                    reset.setVisible(false);
                    play.setVisible(true);
                    bird.setY(BIRD_START_Y);
                    score = 0;
                }
            }
            Display.refresh();
        }
    }

    public static void setup() {
        Display.init();
        Display.setDisplaySize(FRAME_WIDTH, FRAME_HEIGHT);
        Display.centreFrameInWindow();
        Display.setTitle("Flappy Bird");
        Display.show();

        Mouse.init();
        Keyboard.init();

        //background
        Image background = new Image("src/demo/background.png", 0, 0);
        background.setSize(background.getWidth(), 650);

        bgImages[0] = background;
        bgImages[1] = new Image(background, background.getWidth(), 0);

        //flappy bird
        bird = new Image("src/demo/flappy-bird.png");
        bird.setSize(76, 54);
        bird.setLocation((FRAME_WIDTH - bird.getWidth())/2, BIRD_START_Y);

        Draw.setColor(Color.WHITE);

        //buttons
        play = new Button((500 - 150)/2, 400, 150, 80, new Image("src/demo/play.png"), new Image("src/demo/play-hover.png"));
        Display.addButton(play);

        reset = new Button(75, 370, 150, 80, new Image("src/demo/reset.png"), new Image("src/demo/reset-hover.png"));
        Display.addButton(reset);
        reset.setVisible(false);

        quit = new Button(275, 370, 150, 80, new Image("src/demo/quit.png"), new Image("src/demo/quit-hover.png"));
        Display.addButton(quit);
        quit.setVisible(false);

        //music
        Audio bgMusic = Mixer.addAudio(new File("src/demo/background-music.wav"));
        ping = Mixer.addAudio(new File("src/demo/ping-sound-effect.wav"));
        bgMusic.loop();
        bgMusic.setVolume(0.5);
    }

    public static void inGame() {
        //scrolling background
        scrollingBackground(bgImages, SCROLL);

        //add pipes
        if (!pipes.isEmpty()) {
            Image newestPipe = pipes.get(pipes.size() - 1);

            if (newestPipe.getX() + newestPipe.getWidth() <= FRAME_WIDTH - PIPE_DISTANCE) {
                pipes.addAll(addRandomPipes(bird.getHeight(),
                        "src/demo/top-pipe.png", "src/demo/bottom-pipe.png"));
            }
        } else {
            pipes.addAll(addRandomPipes(bird.getHeight(),
                    "src/demo/top-pipe.png", "src/demo/bottom-pipe.png"));
        }

        //Draw pipes
        for (Image pipe : pipes) {
            pipe.setLocation(pipe.getX() - SCROLL, pipe.getY());
            Draw.image(pipe);
        }
        for (Image pipe : pastPipes) {
            pipe.setLocation(pipe.getX() - SCROLL, pipe.getY());
            Draw.image(pipe);
        }

        //flappy bird
        Draw.image(bird);
        bird.setLocation(bird.getX(), bird.getY() + GRAVITY);

        if (Keyboard.isPressed((char) 32) && bird.getY() >= 0) { //space bar (char: 32)
            bird.setLocation(bird.getX(), bird.getY() - BIRD_VY);
        }

        //score
        Draw.text(String.valueOf(score), FRAME_WIDTH/2, 10, font);

        if (bird.getX() >= pipes.get(0).getX() + pipes.get(0).getWidth()) {
            pastPipes.add(pipes.remove(0));
            pastPipes.add(pipes.remove(0));
            score++;
            ping.play(1);
        }

        //game over
        if (bird.collide(pipes.get(0)) || bird.collide(pipes.get(1)) ||
                bird.getY() + bird.getHeight() >= FRAME_HEIGHT || bird.getY() <= 0) {
            gameScreen = false;
            gameOverScreen = true;
            quit.setVisible(true);
            reset.setVisible(true);
        }

        removeOffScreenPipes(pastPipes);
    }



    //scrolling background
    public static void scrollingBackground(Image[] bgImages, int scroll) {
        for (Image bgImage : bgImages) {
            Draw.image(bgImage);
            bgImage.setX(bgImage.getX() - scroll);
            if (bgImage.getX() + bgImage.getWidth() <= 0) {
                bgImage.setX(bgImage.getWidth());
            }
        }
    }

    //generate random pipe sizes
    public static ArrayList<Image> addRandomPipes(int birdHeight, String topPipe, String bottomPipe) {
        ArrayList<Image> pipes = new ArrayList<>();

        int topHeight = 50 + (int)(Math.random() * ((FRAME_HEIGHT /2 + birdHeight - 50) + 1));

        Image top = new Image(topPipe, FRAME_WIDTH, 0);
        top.setSize(PIPE_WIDTH, topHeight);
        pipes.add(top);

        Image bottom = new Image(bottomPipe, FRAME_WIDTH, topHeight + 3*birdHeight);
        bottom.setSize(PIPE_WIDTH, FRAME_HEIGHT - topHeight + 3*birdHeight);
        pipes.add(bottom);

        return pipes;
    }

    public static void removeOffScreenPipes(ArrayList<Image> pipes) {
        for (int i = 0; i < pipes.size(); i++) {
            Image pipe = pipes.get(i);
            if (pipe.getX() + pipe.getWidth() <= 0) {
                pipes.remove(pipe);
                i--;
            }
        }
    }
}