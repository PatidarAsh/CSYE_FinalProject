package application.Tutorial;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class GetTurorialHBOX {
	
	public static HBox getTHbox() {
		HBox tb = new HBox();
		tb.setPadding(new Insets(5,10,5,10));
		tb.setSpacing(5);
		ImageView image = new ImageView(new Image("/tutorialimage/tutorial.png"));
		image.setPreserveRatio(true);
		image.setFitHeight(100);

		
		
		
		
		
		return tb;
		
	}

}
