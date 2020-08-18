package chapter4;

import shared.mosaic.Mosaic;
/**
 * @author David J. Eck (modified by JDav)
 * This program opens a window full of randomly colored squares.  A "disturbance"
 * moves randomly around in the window, copying the color of a random square that it visits to 
 * one of its neighbors. The program runs until the user closes the window.
 */

public class E_07_UniformMosaic {
	
	final static int ROWS = 20;        // Number of rows in mosaic.
    final static int COLUMNS = 30;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 20; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbances in a random walk around the window
     * as long as the window is open.
     */
    
	public static void main(String[] args) {
		Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        fillWithRandomColors();
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while (true) {
            copyingColor(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(5);  // Remove this line to speed things up!
        }
	}
	
	/**
	 * @author David J. Eck
     * Fills the window with randomly colored squares.
     * Precondition:   The mosaic window is open.
     * Postcondition:  Each square has been set to a random color. 
     */
    static void fillWithRandomColors() {
        for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                changeToRandomColor(row, column);  
            }
        }
    }  // end fillWithRandomColors

	
	/**
	 * @author David J. Eck
     * Changes one square to a new randomly selected color.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a random color.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToRandomColor(int rowNum, int colNum) {
        int red = (int)(256*Math.random());    // Choose random levels in range
        int green = (int)(256*Math.random());  //     0 to 255 for red, green, 
        int blue = (int)(256*Math.random());   //     and blue color components.
        Mosaic.setColor(rowNum,colNum,red,green,blue);  
    }  // end changeToRandomColor
    
    /**
     * @author JDav
     * Copy the color of the current selected square to one of its neighbors
     * Precondition:	A square has already been randomly selected 
     * Postcondition: 	The selected square and its neighbor have the same color 
     * @param rowNum the row number of the current selected square, counting rows down from 0 at the top
     * @param colNum the column number of the current selected square, counting columns over from 0 at the left
     */
    static void copyingColor(int rowNum, int colNum) {
    	//Selecting one neighbor [above, below, to the left, to the right]
    	byte n = (byte)(Math.random()*4);
    	int rowNeighbor = rowNum, colNeighbor = colNum;
    	switch(n) {
	    	case 0: //above
	    		rowNeighbor = (rowNum-1 < 0)? ROWS-1: rowNum-1;
	    		break;
	    	case 1: //to the right
	    		colNeighbor = (colNum+1 >= COLUMNS)? 0: colNum+1;
	    		break;
	    	case 2: //below
	    		rowNeighbor = (rowNum+1 >= ROWS)? 0: rowNum+1;
	    		break;
	    	case 3: //to the left
	    		colNeighbor = (colNum-1 < 0)? COLUMNS-1: colNum-1;
	    		break;
    	}
    	//Copying the color
    	Mosaic.setColor(rowNeighbor, colNeighbor, Mosaic.getColor(rowNum, colNum));    	
    }
    
	/**
     * @author David J. Eck
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  currentRow or currentColumn is changed to one of the
     *                 neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid.
     */
    static void randomMove() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
        case 0:  // move up 
            currentRow--;
            if (currentRow < 0)
                currentRow = ROWS - 1;
            break;
        case 1:  // move right
            currentColumn++;
            if (currentColumn >= COLUMNS)
                currentColumn = 0;
            break; 
        case 2:  // move down
            currentRow ++;
            if (currentRow >= ROWS)
                currentRow = 0;
            break;
        case 3:  // move left  
            currentColumn--;
            if (currentColumn < 0)
                currentColumn = COLUMNS - 1;
            break; 
        }
    }  // end randomMove
}