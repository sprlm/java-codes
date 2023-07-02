/*
 * File: Calculator.java
 * ---------------------
 * This class is the main class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date modified: July 22, 2019
 *
 */


import acm.graphics.GPoint;
import acm.program.*;
import java.awt.event.MouseEvent;


public class Calculator extends GraphicsProgram {

    private static final double CANVAS_WIDTH = 540;
    private static final double CANVAS_HEIGHT = 740;
    private CalculatorLayout calculatorLayout;

    private double result = 0;
    private char operator = '0';

    public void run() {
        setTitle("LBYCPEI Calculator");
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        calculatorLayout = new CalculatorLayout(getHeight());
        add(calculatorLayout);
        addMouseListeners();
    }


    public void mouseClicked(MouseEvent e) {
        GPoint click = new GPoint(e.getPoint());
        MyButton buttonPressed = calculatorLayout.getButtonAt(click);
        if (buttonPressed != null) {
            int intResult;
            switch (buttonPressed.getText()) {
                case "CE ":
                    calculatorLayout.clearMainDisplay();
                    break;
                case "C":
                    calculatorLayout.clearMainDisplay();
                    calculatorLayout.clearMemoDisplay();
                    operator = '0';
                    result = 0;
                    break;
                case "⌫":
                    calculatorLayout.deleteOneCharacterMain();
                    break;
                case "÷": case "x": case "-": case "+":
                    if (!calculatorLayout.getNumBuffer().equals("0")) {
                        calculatorLayout.setMemoDisplay(calculatorLayout.getMainDisplay() + buttonPressed.getText().charAt(0));
                        if (operator != '0') result = MathHandler.evaluate(result, Double.parseDouble(calculatorLayout.getMainDisplay()), operator);
                        else result = Double.parseDouble(calculatorLayout.getMainDisplay());
                        calculatorLayout.clearNumBuffer();
                        if (result % 1 == 0) {
                            intResult = (int) result;
                            calculatorLayout.setMainDisplay(Integer.toString(intResult));
                        }
                        else { calculatorLayout.setMainDisplay(Double.toString(result)); }
                    }
                    else {
                        calculatorLayout.deleteOneCharacterMemo();
                        calculatorLayout.setMemoDisplay(buttonPressed.getText());
                    }
                    operator = buttonPressed.getText().charAt(0);
                    break;
                case ".":
                    if (!calculatorLayout.getMainDisplay().contains(".")) calculatorLayout.setMainDisplay('.');
                    break;
                case "±":
                    calculatorLayout.negateElement();
                    break;
                case "=":
                    calculatorLayout.setMemoDisplay(calculatorLayout.getMainDisplay() + buttonPressed.getText().charAt(0));
                    if (operator != '0') result = MathHandler.evaluate(result, Double.parseDouble(calculatorLayout.getMainDisplay()), operator);
                    else result = Double.parseDouble(calculatorLayout.getMainDisplay());
                    calculatorLayout.clearNumBuffer();
                    if (result % 1 == 0) {
                        intResult = (int) result;
                        calculatorLayout.setMainDisplay(Integer.toString(intResult));
                    }
                    else { calculatorLayout.setMainDisplay(Double.toString(result)); }
                    break;
                default:
                    calculatorLayout.setMainDisplay(buttonPressed.getText().charAt(0));
                    break;
            }
        }
    }


    // Solves java.lang.NoClassDefFoundError
    public static void main(String[] args) {
        (new Calculator()).start(args);
    }
}