/*
 * Name:
 * Section Leader:
 * File: Chess.java
 * ------------------
 * This program plays the game Chess.
 */

import java.awt.Color;
import java.awt.event.*;

/** The main class responsible for managing the chess game */
public class Chess extends GraphicsProgram{

	int[] highlighted = new int[2];

	/** Object responsible for handling the graphical display on the screen */
	ChessDisplay display;
	
	/** Object that keeps track of the locations of all pieces */
	ChessBoard board;

	/** Method called before run responsible for initializing the ChessDisplay and 
	 *  ChessBoard objects */
	public void init()
	{
		display = ChessDisplay.getInstance(this);			// This line is required, don't change it
		board = new ChessBoard();
		
		display.useRealChessLabels(false);			// Use this method to change how the board is labeled
															// on the screen. Passing in true will label the board
															// like an official chessboard; passing in false will
															// label the board like it is indexed in an array and
															// in ChessDisplay.
	}
	
	/** The main method that runs the program */
	public void run()
	{
		// You fill this in.
		display.draw(board);
		addMouseListeners();
	}
 
	public void mouseClicked(MouseEvent e) {
		int[] mouse = display.getLocation(e.getX(), e.getY());
		if (board.pieceAt(mouse[0], mouse[1]) != null) {
			display.unselectSquare(highlighted[0]+1, highlighted[1]+1);
			display.selectSquare(mouse[0], mouse[1], Color.GREEN);
			if (mouse[0] == highlighted[0] && mouse[1] == highlighted[1]) {
				display.unselectSquare(mouse[0]+1, mouse[1]+1);
				highlighted[0] = 0;
				highlighted[1] = 0;
			}
			else {
				highlighted[0] = mouse[0];
				highlighted[1] = mouse[1];
			}
		}
		else display.unselectAll();
		display.draw(board);
	}
}

