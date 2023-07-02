import acm.graphics.GLabel;
import acm.program.*;
import java.awt.*;
public class Main extends GraphicsProgram {
    public void run() {
        GLabel text = new GLabel("Hello LBYCPEI OOP!");
        text.setFont("Serif-italic-48");
        text.setColor(Color.GREEN);
        double x = (getWidth() - text.getWidth()) / 2;
        double y = (getHeight() + text.getAscent()) / 2;
        add(text, x, y);        // adding text label  to the center 
    }
    public static void main (String [] args){    // Solves java.lang.NoClassDefFoundError 
        (new Main()).start(args);
    }
}