/*
 * Name:
 * Section Leader:
 * File: ChessBoard.java
 * ------------------
 * This class represents the ChessBoard. Its job is to keep track of where all
 * of the pieces are. Since we just learned about two-dimensional arrays, it 
 * might be a good idea to use one here (just a hint). Currently, it doesn't do 
 * anything, but it does have four methods for you to fill in. These are the only
 * required methods in this class. As long as these work, feel free to do whatever
 * else you want to get this class working.
 */

public class ChessBoard extends DrawableObject{

	/** Constant that sets the size of the chess board */
	public static final int BOARD_SIZE = 8;

	// The constructor will need to initialize whatever data structure you’re going
	// to use to store the ChessPieces and their locations.



	// The job of the constructor would be to initialize this Array to all nulls,
	// as initially, there aren't any pieces on the board.
	
	/** Constructor for the ChessBoard class (do whatever you want with this) */
	public ChessBoard()
	{
		// You fill this in.


		// Note: In Java, each class variable, instance variable, or array component is
		//initialized with a default value when it is created
		//For all reference types, the default value is null.


	}
	
	/** Returns the ChessPiece currently residing at the specified row and 
	 * column. If no piece exists at the specified location, should return 
	 * null.
	 */
	public ChessPiece pieceAt(int row, int col)
	{
		return null;
	}
	
	/** Adds the specified ChessPiece to the ChessBoard (hint: ChessPieces know their
	 * own rows and columns. You can use this to figure out where to place the piece)
	 */
	public void addPiece(ChessPiece piece)
	{
		// If the user attempts to add a piece to a location where one already exists,
		// addPiece should overwrite the old piece with the new one.

	}
	
	/** Removes the piece at the specified location from the board.
	 */
	public void removePiece(int row, int col)
	{

	}


	
}
