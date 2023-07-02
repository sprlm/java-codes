import acm.graphics.GCompound;
import acm.graphics.GImage;

class BrickWall extends GCompound {

    private static final double CANVAS_WIDTH = 640;
    private static final double CANVAS_HEIGHT = 720;
    private static final int NBRICKS_PER_ROW = 10;
    private static final int NBRICKS_PER_COL = 10;
    private static final double BRICK_GAP = 4;
    private static final double BRICK_WIDTH = Math.floor((CANVAS_WIDTH - (NBRICKS_PER_ROW + 1.0) * BRICK_GAP) / NBRICKS_PER_ROW);
    private static final double BRICK_HEIGHT = 30;
    private static final double BRICK_Y_OFFSET = 60;   // from top

    BrickWall () {
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j < NBRICKS_PER_COL; j++) {
                for (int k = 0; k < NBRICKS_PER_ROW; k++) {
                    GImage brick = new GImage("assets/Breakout-Images (" + (((j + 1) * 2) - i) + ").png");
                    brick.setSize(BRICK_WIDTH, BRICK_HEIGHT);
                    add(brick, 2 + (BRICK_GAP * (k + 1)) + (k * BRICK_WIDTH), BRICK_Y_OFFSET + ((BRICK_HEIGHT + BRICK_GAP) * j));
                }
            }
        }
    }

    int getNbricksPerRow() {
        return NBRICKS_PER_ROW;
    }

    int getNbricksPerCol() {
        return NBRICKS_PER_COL;
    }

    void hitBrick (double x, double y) {
        remove(getElementAt(x, y));
    }
}
