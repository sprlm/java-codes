/*
 * File: HangmanCanvas.java
 * ---------------------
 * This class holds the graphics elements to the Hangman game.
 * Author: Cobalt - M.Cabatuan
 * Date modified: 06/11/2019
 */


import acm.graphics.GCanvas;
import acm.graphics.GLabel;

class HangmanCanvas extends GCanvas {

    private static final int TEXT_HEIGHT = 20;   // you can modify this to suit your ascii art
    private static final int TEXT_X_OFFSET = 12;   // you can modify this to suit your ascii art
    private int textX;
    private int textY;


    /**
     * Resets the display so that only the hangman scaffold appears
     */
    void reset() {
        textX = TEXT_X_OFFSET;
        textY = TEXT_HEIGHT;
    }

    void printText(String text){
        GLabel line = new GLabel(text);
        textY += TEXT_HEIGHT;
        line.setFont("Monospaced-Bold-16");
        add(line,  textX , textY );
    }
}
