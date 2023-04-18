package application.tutorial;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GetTutorialStage {

	static	Label lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	static	FlowPane pane2;
	static	Scene scene2;
	static	Stage stage2;

	
	public static Stage getTutorialStage() {
		
		
		lbl1 = new Label("Scene1");
		lbl2 = new Label("Game Tutorial");
		lbl3 = new Label();
		lbl3.setText("To Play this game, you should follow this steps:");
		lbl4 = new Label();
		lbl4.setText("First, you should search your word.");
		lbl5 = new Label("_____Use arrow keys to move (up/down/right/left)");
		lbl6 = new Label("_____enter to select each letter of the word.");
		lbl7 = new Label("_____Use backspace to delete the most recent letter");
		
	
		
		
		pane2 = new FlowPane();
	    pane2.setVgap(10);
	    
	    pane2.setStyle("-fx-background-color:#B0E0E6;-fx-padding:10px;");
	    pane2.getChildren().addAll(lbl2,lbl3,lbl4,lbl5,lbl6,lbl7);
	   
	    scene2 = new Scene(pane2, 400, 400);
	    scene2.setFill(Color.web("#708090"));
	    stage2 = new Stage();
	    stage2.setScene(scene2);
	    stage2.setResizable(false);
	    
	    stage2.initModality(Modality.APPLICATION_MODAL);
	    stage2.setTitle("Game Tutorial");
	    stage2.show();
	    
	    
		return stage2;
		
	}

	

}
