import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Menu {

	//this is a copy of the namealert but repurposed to display player and treasure information
	public static void display(Player Player){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Menu");
		Label label = new Label("Player & Treasure Status");
		label.setUnderline(true);

		Text playerStats = new Text("Name: "+Player.getName()+""
				+ "\nPower: " +Player.getPower()+ ""
				+ "\nFortitude: "+Player.getFortitude()+""
				+ "\nSpeed: "+Player.getSpeed()+""
				+ "\nScore: "+Player.getScore()+" ");
		Text treasureStats = new Text("Held Treasure: "+Player.heldItem.getName()+""
				+ "\nDescription: "+Player.heldItem.getDescription()+""
				+ "\nPower: " +Player.heldItem.getPower()+ ""
				+ "\nFortitude: "+Player.heldItem.getFortitude()+""
				+ "\nSpeed: "+Player.heldItem.getSpeed()+""
				+ "\nValue: "+Player.heldItem.getValue()+" ");
		//HBox menubox = new HBox(playerStats, treasureStats);
		//menubox.setAlignment(Pos.CENTER);
		//menubox.setPadding(new Insets(10,10,10,10));
		treasureStats.setWrappingWidth(270);
		Button close = new Button("Close");
		close.setOnAction(e -> window.close());
		VBox layout = new VBox(10, label, playerStats, treasureStats, close);
		Scene scene = new Scene(layout, 400, 300);
		window.setScene(scene);
		window.showAndWait();
	}
}
