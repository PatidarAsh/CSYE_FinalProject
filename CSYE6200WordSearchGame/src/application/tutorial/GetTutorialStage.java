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

	static	Label lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7, lbl8;
	static	FlowPane pane2;
	static	Scene scene2;
	static	Stage stage2;

	
	public static Stage getTutorialStage() {
		
		
		lbl1 = new Label("Scene1");
		//lbl2 = new Label("Game Tutorial \n");
		lbl3 = new Label("To Play this game, follow the steps:");
		lbl3.setStyle("-fx-font:100px 'Apple Chancery'; -fx-fill: #418aa5; -fx-font-size: 14pt;");
		lbl4 = new Label("    1) First, search for the word in puzzle.");
		lbl4.setStyle("-fx-font:100px 'Apple Chancery'; -fx-fill: #418aa5; -fx-font-size: 12pt;");
		lbl8 = new Label("    2) Then, select letters with keyboard.");
		lbl8.setStyle("-fx-font:100px 'Apple Chancery'; -fx-fill: #418aa5; -fx-font-size: 12pt;");		
		lbl5 = new Label("           - Use arrow keys to move (up/down/right/left)");
		lbl5.setStyle("-fx-font:100px 'Bradley Hand'; -fx-fill: #418aa5; -fx-font-size: 10pt;");		
		lbl6 = new Label("           - Enter to select each letter of the word.");
		lbl6.setStyle("-fx-font:100px 'Bradley Hand'; -fx-fill: #418aa5; -fx-font-size: 10pt;");		
		lbl7 = new Label("           - Use backspace to delete the most recent letter");
		lbl7.setStyle("-fx-font:100px 'Bradley Hand'; -fx-fill: #418aa5; -fx-font-size: 10pt;");		

		
	
		
		
		pane2 = new FlowPane();
	    pane2.setVgap(10);
	    
	    pane2.setStyle("-fx-background-color:#c2d9d1;-fx-padding:10px;");
	    pane2.getChildren().addAll(lbl3,lbl4, lbl8,lbl5,lbl6,lbl7);
	   
	    scene2 = new Scene(pane2, 400, 250);
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
