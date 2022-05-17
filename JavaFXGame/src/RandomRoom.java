import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class RandomRoom {
	//this class will create a scene for a random room every time the enter door button is pressed on the launch pad
	Scene room;
	Label roomName, choiceQuestion, choiceQuestion2;
	Text roomDescription;
	VBox roomvbox;
	HBox playerChoice;
	ChoiceBox<String> skillChoice;
	Button continuebtn;
	Boolean success;
	Success success1;
	Failure failure;
	public
	RandomRoom(Stage window, Scene main, Scene room2,EventRoomBox Rooms, Player Player){

		roomName = new Label(Rooms.randomRoom().getName());
		roomDescription = new Text(Rooms.EventRoom[Rooms.randomNum2].getDescription());
		roomDescription.setWrappingWidth(530);
		choiceQuestion = new Label("Will face this challenge with");
		choiceQuestion2 = new Label("?");
		skillChoice = new ChoiceBox<>();
		skillChoice.getItems().addAll("power", "speed", "fortitude");
		skillChoice.setValue("power");
		playerChoice = new HBox(5, choiceQuestion, skillChoice, choiceQuestion2);
		playerChoice.setAlignment(Pos.CENTER);
		continuebtn = new Button("Continue");
		//this button determines your life or death, with the success and failure scenes
		continuebtn.setOnAction(e -> {
			success = Rooms.EventRoom[Rooms.randomNum2].skillCheck(skillChoice.getValue(), Player);
			if (success){
				success1 = new Success(window, room2, Player, Rooms.EventRoom[Rooms.randomNum2]);
				window.setScene(success1.getScene());
			}
			if (!success){
				failure = new Failure(window, Player, Rooms.EventRoom[Rooms.randomNum2]);
				window.setScene(failure.getScene());
			}
		});
		roomvbox = new VBox();
		roomvbox.getChildren().addAll(roomName, roomDescription, playerChoice, continuebtn);
		roomvbox.setPadding(new Insets(10,10,10,10));
		roomvbox.setSpacing(5);
		roomvbox.setAlignment(Pos.CENTER);
		room = new Scene(roomvbox, 550, 150);
	}
	Scene getRoom(){return room;}


}
