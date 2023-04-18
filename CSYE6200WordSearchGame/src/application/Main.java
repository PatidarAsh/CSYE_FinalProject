package application;
	

import application.Main.Difficulty;
import javafx.animation.AnimationTimer;
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
    Scene scene1, mainScene, scene2; // The three scenes to contain the three views of Difficulty Selection,
                                                // Main Game, and Game Over
    GraphicsContext gc; // Graphics Context used to print the Main Game screen
    String input = new String(); // Stores the word that the user selects
    Base game = new Base();
   
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
	        
	        //set frontend
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

			/* Setting Scene2 for ending of game 
			 * */
	        
	        //
			Text closing = new Text("Good Job!");
			closing.setId("fancytext");                            
			closing.setText("Good Job!\n You found all of the words");
			Text retry = new Text("Do you want to play again?");  
			retry.setId("labeltext");                     
			retry.setText("Do you want to play again?");
			
		    VBox labelClosing = new VBox();
		    labelClosing.setAlignment(Pos.TOP_LEFT);
		    labelClosing.getChildren().addAll(closing,retry);
		    
		    //create Hbox for button to select game difficulty 
	        Button buttonYes = new Button("Yea");               
		    Button buttonNo = new Button("I'm done");
		    
		    HBox btnForRetry=new HBox();
		    btnForRetry.setAlignment(Pos.TOP_LEFT);
		    btnForRetry.getChildren().addAll(buttonYes, buttonNo);   // Adds Buttons 
		    btnForRetry.setSpacing(30);
	        
	        VBox rootClosing = new VBox(VBOX_SPACING);
	        
	        rootClosing.setBackground(new Background(
	                new BackgroundImage(
	                        new Image("/backgroundImage/bg_img1.jpeg"),
	                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
	                        new BackgroundPosition(Side.LEFT, 0, true, Side.BOTTOM, 0, true),
	                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, false, true)
	                )));
	        
	        rootClosing.setAlignment(Pos.TOP_LEFT);
	        rootClosing.getChildren().addAll(labelClosing, btnForRetry);
	        scene2 = new Scene(rootClosing, windowSize, windowSize);

	        AnimationTimer mainGame = new AnimationTimer() {
	            @Override
	            public void handle(long arg0) {
	                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 
	                
	                getEverything();
	                input = game.getInput();
	                checkForEnd(primaryStage);
	            }
	        };

	        primaryStage.setScene(scene1); 
	        primaryStage.show(); 
			
			buttonEasy.setOnAction(e -> { 
	            difficulty = Difficulty.EASY; 
	            game.initmatrix(difficulty);
	            boardSize = game.getBoardSize();
	            primaryStage.setScene(mainScene); 
	            mainGame.start(); 
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
	
	
	
	/**
     * This prints the contents of the gameBoard char array to the console, to be
     * used for debugging purposes only.
     * 
     * <p>
     * To run, uncomment the "printGameBoard()" line in initGameBoard()
     * <p>
     */
    public void printGameBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(game.getBoardPos(i, j) + "  ");
            }
            System.out.println();
        }
    }

    /**
     * This prints the gameBoard char array to the canvas, and is used to
     * graphically show the game board to the user
     */
    public void gcPrintGameBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                gc.fillText(String.valueOf(game.getBoardPos(i, j)), (25 + (20 * j)), (100 + (20 * i)));
            }
        }
    }
    
    public void printWordList() {
        int rowCounter = 0;
        int colCounter = 0;
        int indent = 15;
        for (int i = 0; i < game.getWordListSize(); i++) {
            gc.fillText(game.getWordListValue(i), (indent + (125 * colCounter)), (indent + (20 * rowCounter)));
            colCounter++;
            if (colCounter == 4) {
                colCounter = 0;
                rowCounter++;
            }
        }
    }
    
    //reverse b/w color to show current select letter 
    public void reverseColor() {
        gc.save(); 
        gc.setFill(Color.BLACK);
        gc.fillRect((22 + (20 * colSelection)), (88 + (20 * rowSelection)), 15, 15);
        gc.setFill(Color.WHITE);
        gc.fillText(String.valueOf(game.getBoardPos(rowSelection, colSelection)), (25 + (20 * colSelection)),
                (100 + (20 * rowSelection)));
        gc.restore(); 
    }
    
    //display current selected letters
    public void printSelectedWord() {
        gc.fillText("Word Selected: " + input, 15, 75);
    }
    
    //method for animation timer, contains everything in the game scene
    public void getEverything() {
        gcPrintGameBoard();
        printWordList();
        reverseColor();
        printSelectedWord();
    }
    
    public void checkForEnd(Stage gameStage) {
        if (game.getWordListSize() == 0) {
            gameStage.setScene(scene2);
        }
    }
}
