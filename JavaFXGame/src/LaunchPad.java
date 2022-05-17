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

class LaunchPad {
	private
	Scene launchpad;
	Label launchlabel;
	Text launchtext;
	Button enterbtn, menubtn, exitbtn;
	VBox mainlaunch;
	HBox buttonpanel;
	RandomRoom RandomRoom;
	Player Player;
//this is the main screen you see between rooms and examning your character, its very obvious what this is when you read the layout.

	public
	LaunchPad(Stage window, Scene scene, TreasureBox Treasures, Player Player){
		this.Player = Player;
		//text fields
		launchlabel = new Label("Chamber of Myriad Doors");
		launchtext = new Text("A hall filled with doors that shift and change. "
				+ "\nSome doors depict scenes of hope and triumph, while others show only despair and darkness."
				+ "\nYou stand at the precipice. What will you do adventurer?");
		launchlabel.setAlignment(Pos.CENTER);
		launchtext.setTextAlignment(TextAlignment.CENTER);
		//buttons
		enterbtn = new Button ("Enter a door");
		enterbtn.setOnAction(e -> {
			EventRoomBox Rooms = new EventRoomBox(Treasures);
			RandomRoom = new RandomRoom(window, scene, launchpad, Rooms, Player);
			window.setScene(RandomRoom.getRoom());
		});
		menubtn = new Button ("Examine Status");
		menubtn.setOnAction(e -> Menu.display(Player));
		exitbtn = new Button ("Give up");
		exitbtn.setOnAction(e-> {
			ConfirmationCheck.display();
			if (ConfirmationCheck.confirmation){
				try {
					Mapper.toFile(Player);

				} catch (IOException e1) {
					e1.printStackTrace();
				}
				StartMenu NewGame = new StartMenu(window);
				window.setScene(NewGame.getScene());
			}
			else if (!ConfirmationCheck.confirmation){

			}
		});
		//layout
		buttonpanel = new HBox (5, enterbtn, menubtn, exitbtn);
		buttonpanel.setAlignment(Pos.CENTER);
		mainlaunch = new VBox(5, launchlabel, launchtext, buttonpanel);
		mainlaunch.setAlignment(Pos.CENTER);
		launchpad = new Scene(mainlaunch, 550, 130);

	}
	//gets scene for other class buttons loading this scene
	Scene getLaunchPad(){return launchpad;}


};
