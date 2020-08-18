package chapter3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class E_08_Checkerboard extends Application{

	public static void main(String[] args) {
		launch();
	}
	/*Drawing  a 400-by-400 checker board*/
    public void drawPicture(GraphicsContext g, int width, int height) {

        //g.setFill(Color.WHITE);
        //g.fillRect(0, 0, width, height); // First, fill the entire image with a background color.

        int squareX = 0;     // The x-coord of the top left corner of a square.
        int squareY = 0;     // The y-coord of the top left corner of a square.
        int side = 50;   // The width/height of the square
        
        //Drawing 8 squares by each of the 8 rows of the checker board
        for(int row=0; row<8; row++) {
        	for(int col=0; col<8; col++) {
        		//Whether row and column are either both even or both odd -> Use red color. Otherwise, use black color.
        		if(row%2 == 0 && col%2 == 0 || row%2 != 0 && col%2 != 0) {
        			g.setFill(Color.RED);
        		}else{
        			g.setFill(Color.BLACK);
        		}
            	g.fillRect(squareX, squareY, side, side);
            	squareY += side; // Move to the next column but, in the same row
            }
        	//Move to the next row and reset the columns' number 
        	squareX += side;
        	squareY = 0;
        }
    }
	@Override
	public void start(Stage stage) throws Exception {
		int width = 400;   // The width of the image.  You can modify this value!
        int height = 400;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawPicture(canvas.getGraphicsContext2D(), width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("The Checkerboard"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);	
	}
}
