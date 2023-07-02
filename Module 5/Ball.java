import acm.graphics.GOval;
import acm.util.RandomGenerator;

import java.awt.*;

class Ball extends GOval {

    // Ball constants
    private static final double BALL_RADIUS = 12;
    private static final int BALL_DELAY = 1000 / 60;

    // Ball velocity
    private RandomGenerator rgen = RandomGenerator.getInstance();
    private static final double VELOCITY_Y = 3.0;
    private static final double VELOCITY_X_MIN = 1.0;
    private static final double VELOCITY_X_MAX = 3.0;
    private double dx = rgen.nextDouble(VELOCITY_X_MIN + 0.1, VELOCITY_X_MAX);
    private double dy = VELOCITY_Y;

    Ball() {
        super(BALL_RADIUS * 2, BALL_RADIUS * 2);
        setFilled(true);
        setFillColor(Color.GREEN);
    }

    double getRadius() {
        return BALL_RADIUS;
    }

    double getDiameter() {
        return BALL_RADIUS * 2;
    }

    void move() {
        move(dx, dy);
    }

    void reverseX() {
        dx *= -1;
    }

    void reverseY() {
        dy *= -1;
    }

    void delay() {
        pause(BALL_DELAY);
    }
}
