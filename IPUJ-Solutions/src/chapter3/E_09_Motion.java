package chapter3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class E_09_Motion extends Application{

	private void drawFrame(GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {
		//Note: Width: 1020  Height: 620
		int real_x = 10; //OUR working initial coordinate X
        int real_y = 10; //OUR working initial coordinate X
		int real_width = width - real_x*2; //OUR working width will be 1000
    	int real_height = height - real_y*2; //OUR working width will be 600
  
    	//First, we draw the "channels" for the moving square
        //-- The white background
    	g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height); // First, fill the entire image with a background color!
        //-- The OUR working background's borders
        g.setStroke(Color.BLACK);
        g.strokeRect(real_x, real_y, real_width, real_height);
        //-- Delimiting the "channels"
        for(short i = 1; i <= 5; i++) {
        	g.strokeLine(real_x, real_y+i*100, real_width+real_x, real_y+i*100); //To use width as coordinate y, we must add it real_x
        }
        //-- After, we can start to draw our moving squares which will are 100-by-100
        //-- -- General parameters
        int N = real_width-100; //The distance the squares must travel. Minus 100 since we refer to top left corner of the square
        int s_x = real_x; //Initial x-coordinate position at the start of each square, its coordinate y will be different 
        
        //-- Cyclical Movement !!
        
        //-- -- 1st Square        
        int s1_y = real_y; //The coordinate y of the 1st square
        int s1_v = 2; //The "velocity" (x2) of the 1st square
        int s1_cyclicFrameNumber = frameNumber % (N/s1_v); //Allow us a cyclical movement in a velocity "s1_v" and in a distance "N"
        
        g.setFill(Color.DARKRED);
        g.fillRect(s_x + s1_cyclicFrameNumber*s1_v, s1_y, 100, 100);
        
        //-- -- 2nd Square        
        int s2_y = real_y+100; //The coordinate y of the 2nd square
        int s2_v = 1; //The "velocity" (x1) of the 2nd square 
        int s2_cyclicFrameNumber = frameNumber % (N/s2_v); //Allow us a cyclical movement in a velocity "s2_v" and in a distance "N"
        
        g.setFill(Color.BLUEVIOLET);
        g.fillRect(s_x + s2_cyclicFrameNumber*s2_v, s2_y, 100, 100);
        
        //-- -- 3th Square        
        int s3_y = real_y+200; //The coordinate y of the 3th square
        int s3_v = 3; //The "velocity" (x3) of the 3th square 
        int s3_cyclicFrameNumber = frameNumber % (N/s3_v); //Allow us a cyclical movement in a velocity "s3_v" and in a distance "N"
        
        g.setFill(Color.CORAL);
        g.fillRect(s_x + s3_cyclicFrameNumber*s3_v, s3_y, 100, 100);
        
        //-- Oscillatory Movement !! 
		
        //-- -- 4th Square        
        int s4_y = real_y+300; //The coordinate y of the 4th square
        int s4_v = 2; //The "velocity" (x2) of the 4th square 
        int s4_oscilationFrameNumber = frameNumber % (2*(N/s4_v)); //Allow us a oscillatory movement in a velocity "s4_v" and in a distance "N"
        if(s4_oscilationFrameNumber > N/s4_v)
        	s4_oscilationFrameNumber = 2*(N/s4_v) - s4_oscilationFrameNumber;
        
        g.setFill(Color.GOLDENROD);
        g.fillRect(s_x + s4_oscilationFrameNumber*s4_v, s4_y, 100, 100);
        
        //-- -- 5th Square        
        int s5_y = real_y+400; //The coordinate y of the 5th square
        int s5_v = 3; //The "velocity" (x3) of the 5th square 
        int s5_oscilationFrameNumber = frameNumber % (2*(N/s5_v)); //Allow us a oscillatory movement in a velocity "s5_v" and in a distance "N"
        if(s5_oscilationFrameNumber > N/s5_v)
        	s5_oscilationFrameNumber = 2*(N/s5_v) - s5_oscilationFrameNumber;
        
        g.setFill(Color.YELLOWGREEN);
        g.fillRect(s_x + s5_oscilationFrameNumber*s5_v, s5_y, 100, 100);
        
        //-- -- 6th Square        
        int s6_y = real_y+500; //The coordinate y of the 6th square
        int s6_v = 1; //The "velocity" (x1) of the 6th square 
        int s6_oscilationFrameNumber = frameNumber % (2*(N/s6_v)); //Allow us a oscillatory movement in a velocity "s6_v" and in a distance "N"
        if(s6_oscilationFrameNumber > N/s6_v)
        	s6_oscilationFrameNumber = 2*(N/s6_v) - s6_oscilationFrameNumber;
        
        g.setFill(Color.DARKSLATEGRAY);
        g.fillRect(s_x + s6_oscilationFrameNumber*s6_v, s6_y, 100, 100);
	}

	@Override
	public void start(Stage stage) throws Exception {
		int width = 1020;   // The width of the image.  You can modify this value!
        int height = 620;  // The height of the image. You can modify this value!
        Canvas canvas = new Canvas(width,height);
        drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cyclical and Oscillatoy Movement"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);
        AnimationTimer anim = new AnimationTimer() {
            private int frameNum;
            private long startTime = -1;
            private long previousTime;
            public void handle(long now) {
                if (startTime < 0) {
                    startTime = previousTime = now;
                    drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
                }
                else if (now - previousTime > 0.95e9/60) {
                       // The test in the else-if is to guard against a bug that has shown
                       // up in some versions of JavaFX on some computers.  The bug allows
                       // the handle() method to be called many times more than the 60 times
                       // per second that is specified in the JavaFX documentation.
                    frameNum++;
                    drawFrame(canvas.getGraphicsContext2D(), frameNum, (now-startTime)/1e9, width, height);
                    previousTime = now;
                }
            }
        };
        anim.start();	
	}

	public static void main(String[] args) {
        launch();
    }
}
