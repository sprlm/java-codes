import acm.graphics.*;
import acm.program.*;
import java.awt.*;
public class Main extends GraphicsProgram {
    public static final int APPLICATION_WIDTH = 640;
    public static final int APPLICATION_HEIGHT = 480;
    public static final int BRICK_WIDTH = 30;
    public static final int BRICK_HEIGHT = 12;
    public static final int BRICKS_IN_BASE = 14;

    public void run() {

        GLabel text = new GLabel("Created by Matthew Toro");
        text.setFont("Arial-bold-20");

        int initialx = -15;
        int j=0;

        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            initialx += 15;
            for (j = 0; j < BRICKS_IN_BASE-i; j++) {
                GRect brick = new GRect(BRICK_WIDTH,BRICK_HEIGHT);
                add(brick, initialx + (BRICK_WIDTH*j), 446 - (BRICK_HEIGHT*i));
            }
        }

        add(text, 380, 400);
    }
    public static void main (String [] args){    // Solves java.lang.NoClassDefFoundError 
        (new Main()).start(args);
    }
}