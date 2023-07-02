import acm.graphics.GRect;

class Paddle extends GRect {

    // Paddle constants
    private static final double PADDLE_WIDTH = 80;
    private static final double PADDLE_HEIGHT = 12;
    private static final double PADDLE_Y_OFFSET = 30;    // from bottom

    Paddle() {
        super(PADDLE_WIDTH, PADDLE_HEIGHT);
        setFilled(true);
    }

    double getPaddleWidth() {
        return PADDLE_WIDTH;
    }

    double getPaddleHeight() {
        return PADDLE_HEIGHT;
    }

    double getPaddleYOffset() {
        return PADDLE_Y_OFFSET;
    }
}

