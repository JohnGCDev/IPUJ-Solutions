package chapter4;

import shared.mosaic.Mosaic;
/**
 * @author David J. Eck (modified by JDav)
 * This program opens a window full of black colored squares.  A "disturbance"
 * moves randomly around in the window, randomly changing the green component color of each
 * square that it visits.  The program runs until the user closes the window.
 */
public class E_06_GreenMosaic {

	final static int ROWS = 80;        // Number of rows in mosaic.
    final static int COLUMNS = 80;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 5; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.
	
	public static void main(String[] args) {
		Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
		Mosaic.setUse3DEffect(false);
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while (true) {
            changeToRandomColor(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(5);  // Remove this line to speed things up!
        }

	}
	
    /**
     * @author David J. Eck (modified by JDav)
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
        int green = Mosaic.getGreen(rowNum, colNum);
        
        green = (green+25 > 255)? 255: green+25;
        
        Mosaic.setColor(rowNum,colNum,0,green,0);  
        
    }  // end changeToRandomColor
    
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
