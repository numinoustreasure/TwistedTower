import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Success {
	Scene Outcome;
	HBox btnbox;
	VBox layout;
	Label label;
	Text outcomeText;
	Button continuebtn, openbtn;

	public
	Success(Stage window, Scene scene, Player player, EventRoom room){
		//this scene appears upon room survival
		label = new Label("Triumph!");
		label.setUnderline(true);
		label.setAlignment(Pos.CENTER);
		outcomeText = new Text("You have overcome the trial placed in front of you."
				+ "\nWhether that is due to luck or skill, we will find out soon enough."
				+ "\nA chest lays before you, what treasure lays inside?");
		outcomeText.setWrappingWidth(460);
		outcomeText.setTextAlignment(TextAlignment.CENTER);
		continuebtn = new Button("Exit room");
		//these buttons save your score and handle opening of the reward scene
		openbtn = new Button("Open the chest");
		continuebtn.setOnAction(e -> {
			player.addToScore(room.getScore());
			window.setScene(scene);
		});
		openbtn.setOnAction(e -> {
			if (!room.hasItem){
				NameAlert.display("Despair!", "Gross! Cobwebs and dead bugs, looks like you were unlucky this time...");
			}
			else if(room.hasItem){
				RewardPopup.display(room, player);
			}

		});
		btnbox = new HBox(10, openbtn, continuebtn);
		btnbox.setAlignment(Pos.CENTER);
		layout = new VBox(10, label, outcomeText, btnbox);
		layout.setAlignment(Pos.CENTER);

		Outcome = new Scene(layout, 480, 130);
	}
	public Scene getScene(){return Outcome;}

}
