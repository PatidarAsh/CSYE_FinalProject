package application;
	

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;


public class Main extends Application {
	enum Difficulty {
        EASY, MEDIUM, HARD
    }

    final int windowSize = 600; // Sets the window size
    int boardSize;
    int colSelection = 4; // The column that the user currently has selected
    int rowSelection = 6; // The row that the user currently has selected
    final int VBOX_SPACING = 25;
    Difficulty difficulty; // Enum variable to contain difficulty setting
    Scene scene1, mainScene; // The three scenes to contain the three views of Difficulty Selection,
                                                // Main Game, and Game Over
    GraphicsContext gc; // Graphics Context used to print the Main Game screen
    String wordIn = new String(); // Stores the word that the user selects
   
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
	        
	        rootWelcome.setAlignment(Pos.TOP_LEFT);
	        rootWelcome.getChildren().addAll(labelWelcome, btnForDifficulty);
	        scene1 = new Scene(rootWelcome, windowSize, windowSize);

			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
			
			Canvas canvas = new Canvas(windowSize, windowSize);
	        gc = canvas.getGraphicsContext2D();

	        Box keyboardNode = new Box();
	        keyboardNode.setFocusTraversable(true);
	        keyboardNode.requestFocus();
//	        keyboardNode.setOnKeyPressed(this);
	        
	        Group rootForMain = new Group();
	        rootForMain.getChildren().addAll(canvas, keyboardNode); // Adds canvas for printing to and the keyboard listener
	        mainScene = new Scene(rootForMain, windowSize, windowSize); // Sets the window size and content to show
	        mainScene.setFill(Color.web("#B0C4DE"));

			
			buttonEasy.setOnAction(e -> { // When Easy selected
	            difficulty = Difficulty.EASY; // Sets difficulty level
	            primaryStage.setScene(mainScene); // Sets the stage to show main game scene


	        });

	     buttonMedium.setOnAction(e -> { // When Medium selected
	            difficulty = Difficulty.MEDIUM; // Sets difficulty level
	            primaryStage.setScene(mainScene); // Sets the stage to show main game scene

	        });

	        buttonHard.setOnAction(e -> { // When Hard selected
	            difficulty = Difficulty.HARD; // Sets difficulty level
	            primaryStage.setScene(mainScene); // Sets the stage to show main game scene

	        });
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
