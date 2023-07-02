/*
 * File: MathHandler.java
 * ---------------------
 *  This class is a helper class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date modified: July 22, 2019
 *
 */


public class MathHandler {

    public static int evaluate(int operand1, int operand2, char operator) {
        int result;
        switch (operator) {
            case '+':
                result = add(operand1, operand2);
                break;
            case '-':
                result = subtract(operand1, operand2);
                break;
            case 'x':
                result = multiply(operand1, operand2);
                break;
            case '÷':
                result = divide(operand1, operand2);
                break;
            default:
                result = 0;
        }
        return result;
    }

    static double evaluate(double operand1, double operand2, char operator) {
        double result;
        switch (operator) {
            case '+':
                result = add(operand1, operand2);
                break;
            case '-':
                result = subtract(operand1, operand2);
                break;
            case 'x':
                result = multiply(operand1, operand2);
                break;
            case '÷':
                result = divide(operand1, operand2);
                break;
            default:
                result = 0;
        }
        return result;
    }



    // Note: '+' method already polymorphic
    private static int add(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private static double add(double operand1, double operand2) {
        return operand1 + operand2;
    }



    // Note: '-' method already polymorphic
    private static int subtract(int operand1, int operand2) {
        return operand1 - operand2;
    }

    private static double subtract(double operand1, double operand2) {
        return operand1 - operand2;
    }

    // Note: '/' method already polymorphic
    private static int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }

    private static double divide(double operand1, double operand2) {
        return operand1 / operand2;
    }

    // Note: '*' method already polymorphic
    private static int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private static double multiply(double operand1, double operand2) {
        return operand1 * operand2;
    }

}
