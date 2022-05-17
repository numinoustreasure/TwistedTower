import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StartMenu {
	Scene scene;
	Label label;
	Button button1, button2, button3;
	HBox buttons;
	GridPane layout;
	public
	StartMenu(Stage window){
		PlayerCreation intro = new PlayerCreation(window, scene);
		label = new Label("Welcome to the Twisted Tower.");
		//buttons
		button1 = new Button ("Enter");
		button2 = new Button ("HiScores");
		button3 = new Button ("Exit");
		button1.setOnAction(e -> window.setScene(intro.getScene1()));
		button2.setOnAction(e -> {
			HiScoreMenu newhs = new HiScoreMenu();
			newhs.display();
		});
		button3.setOnAction(e ->{
			ConfirmationCheck.display();
			if (ConfirmationCheck.confirmation){
				window.close();
			}
			else if (!ConfirmationCheck.confirmation){

			}
		});
		//layout
		buttons = new HBox(5, button1, button2, button3);
		layout = new GridPane();
		label.setAlignment(Pos.CENTER);
		layout.setAlignment(Pos.CENTER);
		layout.add(label, 0, 0);
		layout.add(buttons, 0, 2, 2, 1);
		scene = new Scene(layout, 300, 100);
	}
	public Scene getScene(){return scene;}
}
