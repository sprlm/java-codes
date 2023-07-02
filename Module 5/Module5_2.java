import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.util.MediaTools;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Module5_2 extends GraphicsProgram {

    // Breakout CONSTANTS
    private static final double CANVAS_WIDTH = 640;
    private static final double CANVAS_HEIGHT = 720;

    // Breakout class variables: main actors in the app
    private Paddle paddle;
    private Ball ball;
    private GLabel score;
    private int n_score;
    private GLabel lives;
    private int n_lives = 3;

    private BrickWall brickWall = new BrickWall();

    public void run() {
        setUpGame();
        while (n_lives > 0) {
            if (n_score == brickWall.getNbricksPerCol() * brickWall.getNbricksPerRow() * 2) {
                break;
            }
            setUpBall();
            displayClickConfirmation();
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

        add(brickWall, 0, 0);

        // Set Up Paddle
        paddle = new Paddle();
        add(paddle, (CANVAS_WIDTH / 2) - (paddle.getPaddleWidth() / 2), CANVAS_HEIGHT - paddle.getPaddleHeight() - paddle.getPaddleYOffset());
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
        ball = new Ball();
        add(ball, (CANVAS_WIDTH / 2) - ball.getRadius(), (CANVAS_HEIGHT * 2 / 3) - ball.getRadius());
    }

    private void runGame() {
        AudioClip hitSound = MediaTools.loadAudioClip("assets/boop.wav");
        while (true) {
            ball.move();
            if (n_score == brickWall.getNbricksPerCol() * brickWall.getNbricksPerRow() * 2) {
                return;
            }

            if (ball.getX() <= 0 || ball.getX() >= CANVAS_WIDTH - ball.getDiameter()) {
                ball.reverseX();
            }

            if (ball.getY() <= 0) {
                ball.reverseY();
            }

            if (ball.getY() > CANVAS_HEIGHT) {
                n_lives -= 1;
                lives.setLabel("Lives: " + n_lives);
                remove(ball);
                return;
            }

            GObject collider = getCollidingObject();
            if (collider == paddle) {
                if (ball.getY() <= CANVAS_HEIGHT - paddle.getPaddleYOffset() - paddle.getPaddleHeight() - ball.getDiameter()){
                    hitSound.play();
                    ball.reverseY();
                }
            }
            else if (collider != null && !(collider instanceof GLabel)) {
                if((getElementAt(ball.getX(), ball.getY())) != null) {
                    brickWall.hitBrick(ball.getX(), ball.getY());
            }
                else if (getElementAt( (ball.getX() + ball.getDiameter()), ball.getY()) != null) {
                    brickWall.hitBrick(ball.getX() + ball.getDiameter(), ball.getY());
                }
                else if(getElementAt((ball.getX() + ball.getDiameter()), (ball.getY() + ball.getDiameter())) != null){
                    brickWall.hitBrick(ball.getX() + ball.getDiameter(), ball.getY() + ball.getDiameter());
                }
                else if(getElementAt(ball.getX(), (ball.getY() + ball.getDiameter())) != null){
                    brickWall.hitBrick(ball.getX(), ball.getY() + ball.getDiameter());
                }
                hitSound.play();
                n_score += 1;
                score.setLabel("Score: " + n_score);
                ball.reverseY();
            }

            ball.delay();
        }
    }

    private GObject getCollidingObject() {
        if((getElementAt(ball.getX(), ball.getY())) != null) {
            return getElementAt(ball.getX(), ball.getY());
        }
        else if (getElementAt( (ball.getX() + ball.getDiameter()), ball.getY()) != null) {
            return getElementAt(ball.getX() + ball.getDiameter(), ball.getY());
        }
        else if(getElementAt((ball.getX() + ball.getDiameter()), (ball.getY() + ball.getDiameter())) != null){
            return getElementAt(ball.getX() + ball.getDiameter(), ball.getY() + ball.getDiameter());
        }
        else if(getElementAt(ball.getX(), (ball.getY() + ball.getDiameter())) != null){
            return getElementAt(ball.getX(), ball.getY() + ball.getDiameter());
        }
        else{
            return null;
        }
    }

    private void displayClickConfirmation() {
        GLabel confirmation = new GLabel("LEFT CLICK TO START");
        confirmation.setFont("*-bold-20");
        add(confirmation, (CANVAS_WIDTH - confirmation.getWidth()) / 2, ((CANVAS_HEIGHT - confirmation.getHeight()) *2 / 3) - 50);
        waitForClick();
        remove(confirmation);
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
        if ((mouseX >= paddle.getPaddleWidth() / 2) && (mouseX <= CANVAS_WIDTH - (paddle.getPaddleWidth() / 2))) {
            paddle.setLocation(mouseX - (paddle.getPaddleWidth() / 2), CANVAS_HEIGHT - paddle.getPaddleHeight() - paddle.getPaddleYOffset());
        }
    }

    /* Solves NoClassDefFoundError */
    public static void main(String[] args) {
        new Module5_2().start(args);
    }
}
