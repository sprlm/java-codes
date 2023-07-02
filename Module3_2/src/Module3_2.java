import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import java.awt.*;
import java.awt.event.MouseEvent;
import acm.util.*;
import java.applet.*;

public class Module3_2 extends GraphicsProgram {

    // Breakout CONSTANTS
    private static final double CANVAS_WIDTH = 640;
    private static final double CANVAS_HEIGHT = 720;
    private static final int NBRICKS_PER_ROW = 10;
    private static final int NBRICKS_PER_COL = 10;
    private static final double BRICK_GAP = 4;
    private static final double BRICK_WIDTH = Math.floor((CANVAS_WIDTH - (NBRICKS_PER_ROW + 1.0) * BRICK_GAP) / NBRICKS_PER_ROW);
    private static final double BRICK_HEIGHT = 12;
    private static final double BRICK_Y_OFFSET = 60;   // from top
    private static final double PADDLE_WIDTH = 80;
    private static final double PADDLE_HEIGHT = 12;
    private static final double PADDLE_Y_OFFSET = 30;    // from bottom
    private static final double BALL_RADIUS = 12;
    private static final double VELOCITY_Y = 3.0;
    private static final double VELOCITY_X_MIN = 1.0;
    private static final double VELOCITY_X_MAX = 3.0;
    private static final int BALL_DELAY = 1000 / 60;

    // Breakout class variables: main actors in the app
    private GRect paddle;
    private GOval ball;
    // Ball velocity
    private double dx;
    private double dy;
    // Ball direction randomizer
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private GLabel score;
    private int n_score;
    private GLabel lives;
    private int n_lives = 3;

    public void run() {
        setUpGame();
        while (n_lives > 0) {
            if (n_score == NBRICKS_PER_COL * NBRICKS_PER_ROW * 2) {
                break;
            }
            setUpBall();
            waitForClick();
            runGame();
        }
        if (n_lives == 0) {
            displayLoseScreen();
        }
        else {
            displayWinScreen();
        }
    }


    private void setUpGame() {
        setTitle("LBYCPEI Breakout");
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        // Set Up Bricks
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < NBRICKS_PER_COL; j++) {
                for (int k = 0; k < NBRICKS_PER_ROW; k++) {
                    GImage brick = new GImage("assets/" + (((j + 1) * 2) - i) + "-Breakout-Tiles.png");
                    brick.setSize(BRICK_WIDTH, BRICK_HEIGHT);
                    add(brick, 2 + (BRICK_GAP * (k + 1)) + (k * BRICK_WIDTH), BRICK_Y_OFFSET + ((BRICK_HEIGHT + BRICK_GAP) * j));
                }
            }
        }

        // Set Up Paddle
        paddle = new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
        paddle.setFilled(true);
        add(paddle, (CANVAS_WIDTH / 2) - (PADDLE_WIDTH / 2), CANVAS_HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET);
        addMouseListeners();

        // Set Up Score
        score = new GLabel("Score: " + n_score);
        score.setFont("*-bold-20");
        add(score, 5, 20);

        // Set Up Lives
        lives = new GLabel("Lives: " + n_lives);
        lives.setFont("*-bold-20");
        add(lives, CANVAS_WIDTH - lives.getWidth() - 5, 20);
    }

    private void setUpBall() {
        ball = new GOval(BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        ball.setFillColor(Color.GREEN);
        add(ball, (CANVAS_WIDTH / 2) - BALL_RADIUS, (CANVAS_HEIGHT / 2) - BALL_RADIUS);
    }

    private void runGame() {
        AudioClip hitSound = MediaTools.loadAudioClip("assets/boop.wav");
        dx = rgen.nextDouble(VELOCITY_X_MIN + 0.1, VELOCITY_X_MAX);
        dy = VELOCITY_Y;
        while (true) {
            ball.move(dx, dy);
            if (n_score == NBRICKS_PER_COL * NBRICKS_PER_ROW * 2) {
                return;
            }

            if (ball.getX() <= 0 || ball.getX() >= CANVAS_WIDTH - (BALL_RADIUS * 2)) {
                dx *= -1;
            }

            if (ball.getY() <= 0) {
                dy *= -1;
            }

            if (ball.getY() > CANVAS_HEIGHT) {
                n_lives -= 1;
                lives.setLabel("Lives: " + n_lives);
                remove(ball);
                return;
            }

            GObject collider = getCollidingObject();
            if (collider == paddle) {
                if (ball.getY() <= CANVAS_HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT - (BALL_RADIUS * 2)){
                    hitSound.play();
                    dy *= -1;
                }
            }
            else if (collider != null) {
                remove(collider);
                hitSound.play();
                n_score += 1;
                score.setLabel("Score: " + n_score);
                dy *= -1;
            }

            pause(BALL_DELAY);
        }
    }

    private GObject getCollidingObject() {
        if((getElementAt(ball.getX(), ball.getY())) != null) {
            return getElementAt(ball.getX(), ball.getY());
        }
        else if (getElementAt( (ball.getX() + BALL_RADIUS*2), ball.getY()) != null ) {
            return getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
        }
        else if(getElementAt((ball.getX() + BALL_RADIUS*2), (ball.getY() + BALL_RADIUS*2)) != null ){
            return getElementAt(ball.getX() + BALL_RADIUS*2, ball.getY() + BALL_RADIUS*2);
        }
        else if(getElementAt(ball.getX(), (ball.getY() + BALL_RADIUS*2)) != null ){
            return getElementAt(ball.getX(), ball.getY() + BALL_RADIUS*2);
        }
        else{
            return null;
        }
    }

    private void displayWinScreen() {
        remove(ball);
        remove(paddle);
        GLabel win = new GLabel("YOU WIN!");
        win.setFont("*-bold-40");
        win.setColor(Color.GREEN);
        add(win, (CANVAS_WIDTH - win.getWidth()) / 2, (CANVAS_HEIGHT - win.getHeight()) / 2);
    }

    private void displayLoseScreen() {
        remove(ball);
        remove(paddle);
        GLabel lose = new GLabel("GAME OVER!");
        lose.setFont("*-bold-40");
        lose.setColor(Color.RED);
        add(lose, (CANVAS_WIDTH - lose.getWidth()) / 2, (CANVAS_HEIGHT - lose.getHeight()) / 2);
    }

    public void mouseMoved(MouseEvent mouse) {
        // Get the x coordinate of the mouse
        double mouseX = mouse.getX();
        if ((mouseX >= PADDLE_WIDTH / 2) && (mouseX <= CANVAS_WIDTH - (PADDLE_WIDTH / 2))) {
            paddle.setLocation(mouseX - (PADDLE_WIDTH / 2), CANVAS_HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET);
        }
    }

    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Module3_2().start(args);
    }
}
