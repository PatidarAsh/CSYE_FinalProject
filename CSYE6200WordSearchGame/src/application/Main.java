package application;
	

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	
	Scene scene1;
	final int VBOX_SPACING = 25;
	final int windowSize = 600;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/* Setting Scene1 The Launch Page of Game 
			 * */
			
			Text text = new Text("Welcome to this Word Search"); //creating text
			text.setId("fancytext");                             //setting Id for text
			text.setText("Welcome to This word Search");
			Text LabelDifficulty = new Text("Select Difficulty:");   //creating another text 
			LabelDifficulty.setId("labeltext");                     //setting ID for text 
			LabelDifficulty.setText("Select Difficulty:");
			Button buttonEasy = new Button("Easy");               //creating buttons for 3 different levels in Game
		    Button buttonMedium = new Button("Medium");
		    Button buttonHard = new Button("Hard");
			
		    HBox btnForDifficulty=new HBox();
	        btnForDifficulty.setAlignment(Pos.TOP_LEFT);
	        btnForDifficulty.getChildren().addAll(buttonEasy, buttonMedium, buttonHard);   // Adds Buttons 
	        btnForDifficulty.setSpacing(30);
	        
	        VBox rootForDifficulty = new VBox(VBOX_SPACING);
	        rootForDifficulty.setBackground(new Background(
	                new BackgroundImage(
	                        new Image("/backgroundImage/bg_img1.jpeg"),
	                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
	                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
	                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
	                )));
	        rootForDifficulty.setAlignment(Pos.TOP_LEFT);
	        rootForDifficulty.getChildren().addAll(text, LabelDifficulty, btnForDifficulty);
	        scene1 = new Scene(rootForDifficulty, windowSize, windowSize); // Sets the window size and content to
	                                                                                // show


			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
