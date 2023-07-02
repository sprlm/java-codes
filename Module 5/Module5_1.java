import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Module5_1 extends GraphicsProgram {
    // Set the dimensions of window depending on image size
    public static final int APPLICATION_WIDTH = 640;
    public static final int APPLICATION_HEIGHT = 845;

    public void run() {

        GImage dlsu = new GImage("assets/DLSU2.png");

        GLabel text = new GLabel("• DE • LA • SALLE • UNIVERSITY •");
        text.setFont("Serif-bold-29");

        GOval oval = new GOval(100,100);
        oval.setColor(Color.GREEN);
        oval.setFilled(true);

        GLabel threehundred = new GLabel("300");
        threehundred.setFont("SansSerif-italic-55");
        threehundred.setColor(Color.WHITE);

        GImage lasalle = new GImage("assets/lasalle.jpg");
        lasalle.scale(0.55, 0.73);

        add(dlsu);
        add(text, 76, 334);
        add(oval, 284, 391);
        add(threehundred,285, 459);
        add(lasalle, 269, 557);

        GFlag flag1 = new GFlag(60, 384);
        add(flag1);
        GFlag flag2 = new GFlag(415, 384);
        add(flag2);
    }



    // Solves java.lang.NoClassDefFoundError
    public static void main (String [] args){
        (new Module5_1()).start(args);
    }
}