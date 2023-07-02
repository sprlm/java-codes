import acm.graphics.*;
import acm.program.*;
import java.awt.*;
public class Main extends GraphicsProgram {
    public static final int APPLICATION_WIDTH = 640;
    public static final int APPLICATION_HEIGHT = 480;
    public void run() {
        GRect rect = new GRect(APPLICATION_WIDTH,100);
        rect.setColor(Color.GREEN);
        rect.setFilled(true);

        GRect sky = new GRect(APPLICATION_WIDTH, 380);
        sky.setColor(Color.CYAN);
        sky.setFilled(true);

        GOval oval = new GOval(100,100);
        oval.setColor(Color.ORANGE);
        oval.setFillColor(Color.YELLOW);
        oval.setFilled(true);

        GOval pellet = new GOval(60,60);
        pellet.setColor(Color.WHITE);
        pellet.setFilled(true);

        GArc arc = new GArc(100, 100, 200, 200, 45, 270);
        arc.setColor(Color.YELLOW);
        arc.setFilled(true);

        GLabel text = new GLabel("Created by Matthew Toro");
        text.setFont("Arial-bold-20");

        add(rect,0,380);
        add(sky, 0, 0);
        add(pellet, 330, 240);
        add(oval, 500, 50);
        add(arc, 120, 180);
        add(text, 390, 425);
    }
    public static void main (String [] args){    // Solves java.lang.NoClassDefFoundError 
        (new Main()).start(args);
    }
}