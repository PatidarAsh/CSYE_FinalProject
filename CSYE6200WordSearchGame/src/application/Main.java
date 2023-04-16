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
			
		    //create Vbox for welcomeing text
			Text welcome = new Text("Welcome to this Word Search");
			welcome.setId("fancytext");                            
			welcome.setText("Welcome to This word Search");
			Text select = new Text("Select Difficulty:");  
			select.setId("labeltext");                     
			select.setText("Select Difficulty:");
			
		    VBox labelWelcome = new VBox();
		    labelWelcome.setAlignment(Pos.TOP_LEFT);
		    labelWelcome.getChildren().addAll(welcome,select);
		    
		    //create Hbox for button to select game difficulty 
	        Button buttonEasy = new Button("Easy");               
		    Button buttonMedium = new Button("Medium");
		    Button buttonHard = new Button("Hard");
		    
		    HBox btnForDifficulty=new HBox();
	        btnForDifficulty.setAlignment(Pos.TOP_LEFT);
	        btnForDifficulty.getChildren().addAll(buttonEasy, buttonMedium, buttonHard);   // Adds Buttons 
	        btnForDifficulty.setSpacing(30);
	        
	        VBox rootWelcome = new VBox(VBOX_SPACING);
	        rootWelcome.setBackground(new Background(
	                new BackgroundImage(
	                        new Image("/backgroundImage/bg_img1.jpeg"),
	                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
	                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
	                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
	                )));
	        
	        rootWelcome.setAlignment(Pos.CENTER);
	        rootWelcome.getChildren().addAll(labelWelcome, btnForDifficulty);
	        scene1 = new Scene(rootWelcome, windowSize, windowSize);

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
