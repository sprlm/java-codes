import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Module2_4 extends GraphicsProgram {
    // Set the dimensions of window depending on image size
    public static final int APPLICATION_WIDTH = 640;
    public static final int APPLICATION_HEIGHT = 845;

    public void run() {

        GImage dlsu = new GImage("assets/DLSU2.png");

        GLabel text = new GLabel("• DE • LA • SALLE • UNIVERSITY •");
        text.setFont("Serif-bold-30");

        GOval oval = new GOval(100,100);
        oval.setColor(Color.GREEN);
        oval.setFilled(true);

        GLabel threehundred = new GLabel("300");
        threehundred.setFont("SansSerif-55");
        threehundred.setColor(Color.WHITE);

        add(dlsu);
        add(text, 68, 334);
        add(oval, 284, 391);
        add(threehundred,288, 460);
    }
    // Solves java.lang.NoClassDefFoundError
    public static void main (String [] args){
        (new Module2_4()).start(args);
    }
}