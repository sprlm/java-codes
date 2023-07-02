import acm.graphics.*;
import acm.program.*;
import java.awt.*;
public class Module2_2_C extends GraphicsProgram {
    public static final int APPLICATION_WIDTH = 900;
    public static final int APPLICATION_HEIGHT = 450;
    public void run() {
        GRect blue = new GRect(APPLICATION_WIDTH,APPLICATION_HEIGHT/2);
        blue.setColor(Color.BLUE);
        blue.setFilled(true);

        GRect red = new GRect(APPLICATION_WIDTH,APPLICATION_HEIGHT/2);
        red.setColor(Color.RED);
        red.setFilled(true);

        GPoint[] gp = new GPoint[3];
        gp[0] = new GPoint(0,0);
        gp[1] = new GPoint(0,APPLICATION_HEIGHT);
        gp[2] = new GPoint(420,APPLICATION_HEIGHT/2);

        GPolygon white = new GPolygon(gp);
        white.setColor(Color.WHITE);
        white.setFilled(true);

        GOval sun_center = new GOval(100,100);
        sun_center.setColor(Color.YELLOW);
        sun_center.setFilled(true);

        GLine sun_ray1 = new GLine(0, 0, 0, 200);
        sun_ray1.setColor(Color.YELLOW);

        GLine sun_ray2 = new GLine(0, 0, 200, 0);
        sun_ray2.setColor(Color.YELLOW);

        GLine sun_ray3 = new GLine(0, 0, 150, 150);
        sun_ray3.setColor(Color.YELLOW);

        GLine sun_ray4 = new GLine(150, 0, 0, 150);
        sun_ray4.setColor(Color.YELLOW);

        GLabel text = new GLabel("Created by Matthew Toro");
        text.setFont("Arial-bold-20");

        add(blue,0,0);
        add(red,0,APPLICATION_HEIGHT/2);
        add(white, 0, 0);
        add(sun_center, 100, APPLICATION_HEIGHT/2-50);
        add(sun_ray1, 150, 125);
        add(sun_ray2, 50, 225);
        add(sun_ray3, 70, 150);
        add(sun_ray4, 225, 150);
        createStar(40, 100);
        createStar(40, 400);
        createStar(330, 255);
        add(text, 620, 400);
    }

    private void createStar(int x, int y) {
        GPolygon star = new GPolygon();
        star.setColor(Color.YELLOW);
        star.setFilled(true);
        star.addPolarEdge(20,108);
        star.addPolarEdge(20,180);
        star.addPolarEdge(20,36);
        star.addPolarEdge(20,108);
        star.addPolarEdge(20,333);
        star.addPolarEdge(20,36);
        star.addPolarEdge(20, 252);
        star.addPolarEdge(20,333);
        star.addPolarEdge(20,180);
        star.addPolarEdge(20, 252);
        add(star, x, y);
    }

    public static void main (String [] args){    // Solves java.lang.NoClassDefFoundError 
        (new Module2_2_C()).start(args);
    }
}