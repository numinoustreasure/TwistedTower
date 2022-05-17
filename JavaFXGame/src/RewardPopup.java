

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RewardPopup {
	//this is another popup based off of namealert
	public static void display(EventRoom room, Player player){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Triumph!");
		Text label = new Text("Luck is with you today, you've found an item with a strong aura."
				+ "\nYou've found: "+room.reward.getName()+"!"
						+ "\n"+room.reward.getDescription()+""
								+ "\nWill you replace your "+player.heldItem.getName()+" with this?");
		label.setWrappingWidth(530);
		Button yes = new Button("Yes");
		Button no = new Button("No");
		label.setTextAlignment(TextAlignment.CENTER);
		//this button lets you choose whether or not you want to keep the item from the room
		yes.setOnAction(e -> {
			player.setTreasure(room.getReward());
			window.close();
			});
		no.setOnAction(e ->{
			window.close();
		});
		HBox btnlayout = new HBox(10, yes, no);
		btnlayout.setAlignment(Pos.CENTER);
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, btnlayout);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 550, 200);
		window.setScene(scene);
		window.showAndWait();
	}
}