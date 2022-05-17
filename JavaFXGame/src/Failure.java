import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Failure {
	Scene Outcome;
	HBox btnbox;
	VBox layout;
	Label label;
	Text outcomeText;
	Button continuebtn;
	StartMenu newGame;

	public
	Failure(Stage window, Player player, EventRoom room){
		//this is the scene that displays upon death
		label = new Label("Game Over");
		label.setUnderline(true);
		label.setAlignment(Pos.CENTER);
		outcomeText = new Text("AhaHahaHa! Foolish adventurer, you thought you could get through the "+room.getName()+"!"
				+ "\nYou are just a mere trifle, a mote of dust collected in the darkest corner of my tower."
				+ "\nFear not though, adventurer, your name and worth will be recorded alongside the others who came before you...");
		outcomeText.setWrappingWidth(460);
		outcomeText.setTextAlignment(TextAlignment.CENTER);
		continuebtn = new Button("Exit the tower");
		//all events are handled with lambdas. this will add your score to the hiscore text file for later usage
		continuebtn.setOnAction(e -> {
			player.addToScore(room.getScore());
			try {
				Mapper.toFile(player);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			newGame = new StartMenu(window);
			window.setScene(newGame.getScene());
		});

		btnbox = new HBox(10, continuebtn);
		btnbox.setAlignment(Pos.CENTER);
		layout = new VBox(10, label, outcomeText, btnbox);
		layout.setAlignment(Pos.CENTER);

		Outcome = new Scene(layout, 520, 130);
	}
	public Scene getScene(){return Outcome;}

}