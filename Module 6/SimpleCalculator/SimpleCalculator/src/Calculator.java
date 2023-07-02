/*
 * File: Calculator.java
 * ---------------------
 * This class is the main class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date modified: July 22, 2019
 *
 */


import acm.graphics.GObject;
import acm.program.*;
import java.awt.event.MouseEvent;


public class Calculator extends GraphicsProgram {

    private static final double CANVAS_WIDTH = 540;
    private static final double CANVAS_HEIGHT = 740;
    private CalculatorLayout calculatorLayout;

    private char opBuffer;
    private double operand1;
    private String result;

    private boolean isFirstOp;
    private boolean isPriorEquals;
    private boolean isFirstPoint;
    private boolean isDeletable;


    public void run() {
        setTitle("LBYCPEI Calculator");
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        calculatorLayout = new CalculatorLayout(getHeight());
        add(calculatorLayout);
        addMouseListeners();
        /* TODO: Write your code here */
    }


    public void mouseClicked(MouseEvent e) {
        /* TODO: Write your code here */
    }



    // Solves java.lang.NoClassDefFoundError
    public static void main(String[] args) {
        (new Calculator()).start(args);
    }
}