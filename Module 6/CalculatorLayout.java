/*
 * File: CalculatorLayout.java
 * ---------------------
 *  This class is the layout class for a sample calculator app implementation
 *  Author: Cobalt mkc
 *  Date modified: July 22, 2019
 *
 */


import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;

public class CalculatorLayout extends GCompound {

    private static final int NROWS = 5;     /* Number of rows    */
    private static final int NCOLS = 4;     /* Number of columns */
    private static final int MARGIN = 20;
    private static final char[] labels = {
            ' ', 'C', '⌫', '÷',
            '7', '8', '9', 'x',
            '4', '5', '6', '-',
            '1', '2', '3', '+',
            '±', '.', '0', '='};

    private GLabel memoDisplay;
    private GLabel mainDisplay;
    private StringBuilder memoBuffer;
    private StringBuilder numBuffer;
    private static final String MAIN_FONT = "SansSerif-bold-48";
    private static final String MEMO_FONT = "SansSerif-bold-28";

    CalculatorLayout(double height) {
        double sqSize = height / (NROWS + 1);
        numBuffer = new StringBuilder();
        clearNumBuffer();
        mainDisplay = new GLabel(numBuffer.toString(), MARGIN, MARGIN + 70);
        mainDisplay.setFont(MAIN_FONT);

        memoBuffer = new StringBuilder();
        memoDisplay = new GLabel("", MARGIN, 2 * MARGIN);
        memoDisplay.setFont(MEMO_FONT);

        add(mainDisplay);
        add(memoDisplay);

        int count = 0;
        for (int i = 1; i <= NROWS; i++) {
            for (int j = 0; j < NCOLS; j++) {
                double x = MARGIN + j * sqSize;
                double y = i * sqSize - MARGIN;
                MyButton myButton = (count != 0) ? new MyButton(x, y, sqSize, sqSize, "" + labels[count++])
                        : new MyButton(x, y, sqSize, sqSize, "CE" + labels[count++]);
                add(myButton);
            }
        }
    }

    MyButton getButtonAt(GPoint click) {
        if (getElementAt(click) instanceof MyButton) return (getElementAt(click));
        else return null;
    }

    String getNumBuffer() {
        return numBuffer.toString();
    }

    /* Sample Polymorphic Methods */
    public void setMemoDisplay(char symbol) {
        memoBuffer.append(symbol);
        memoDisplay.setLabel(memoBuffer.toString());
    }

    void setMemoDisplay(String input) {
        memoBuffer.append(input);
        memoDisplay.setLabel(memoBuffer.toString());
    }

    /* Sample Polymorphic Methods */
    void setMainDisplay(char symbol) {
        if (numBuffer.length() > 0 && numBuffer.charAt(0) == '0') { // Do not append on initial zero
            numBuffer.setCharAt(0, symbol);
        } else {
            numBuffer.append(symbol);
        }
        mainDisplay.setLabel(numBuffer.toString());
    }

    void setMainDisplay(String input) {
        mainDisplay.setLabel(input);
    }


    String getMainDisplay() {
        return numBuffer.toString();
    }

    void clearMainDisplay() {
        clearNumBuffer();
        mainDisplay.setLabel("0");
    }

    void clearMemoDisplay() {
        clearMemoBuffer();
        memoDisplay.setLabel("");
    }

    void clearNumBuffer() {
        numBuffer.setLength(1);
        numBuffer.setCharAt(0, '0');
    }

    private void clearMemoBuffer() {
        memoBuffer.setLength(0);
    }


    void negateElement() {
        if (!numBuffer.toString().equals("0")) {
            if (numBuffer.charAt(0) != '-') {
                numBuffer.insert(0, '-');
            } else {
                numBuffer.deleteCharAt(0);
            }
        }
        mainDisplay.setLabel(numBuffer.toString());
    }

    void deleteOneCharacterMain() {
        if (numBuffer.length() == 0 || numBuffer.toString().equals("0")) {
            return;
        }
        numBuffer.setLength(numBuffer.length() - 1);
        mainDisplay.setLabel(numBuffer.toString());
    }

    void deleteOneCharacterMemo() {
        if (memoBuffer.length() == 0 || memoDisplay.toString().equals("")) {
            return;
        }
        memoBuffer.setLength(memoBuffer.length() - 1);
    }
}
