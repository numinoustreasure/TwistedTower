import java.util.regex.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PlayerCreation {
	//this class handles the initial player creation. we keep most of this in the constructor so we don't have to pass something new into this every time
	//we do want to create this fresh every time the game begins though, so we just handle all logic in the constructor.
	private
	Text intro1, intro2, intro3, intro4;
	TextField nameInput;
	Button accept, continuebtn, continuebtn2, continuebtn4;
	GridPane grid1;
	HBox hbox3;
	VBox vbox2, vbox3, vbox4;
	Label itemQuestion, itemQuestion2;
	Scene introScene1,introScene2,introScene3,introScene4;
	ChoiceBox<String> startingItem;
	String name, heldItem;
	int power, speed, fortitude, score;
	public
	Scene getScene1(){
		return introScene1;
	}
	String getName(){
		return nameInput.getText();
	}
	String getItem(){
		return startingItem.getValue();
	}


	PlayerCreation(Stage window, Scene scene){
		//-----------------text display---------------------------
		//intro scene 1
		intro1 = new Text();
		intro1.setText("As you approach the bottom of the mighty and dark tower, you encounter a dust covered stele."
				+ "\nYou wipe the dust away and find words etched into it. They read:"
				+ "\nBold adventurer, leave your mark upon the stone lest it be forgotten alongside your bones...");
		intro1.setTextAlignment(TextAlignment.JUSTIFY);
		//accept name
		nameInput = new TextField();
		nameInput.setPromptText("Enter your name");
		nameInput.setFocusTraversable(false);
		accept = new Button("Accept");
		accept.setOnAction(e -> {
			if (!isName(nameInput.getText())){
				NameAlert.display("Invalid name!", "Names cannot contain spaces.");
				nameInput.clear();
			}
			else if (nameInput.getText().isEmpty()){
				NameAlert.display("Invalid name!", "Names cannot be empty.");
				nameInput.clear();
			}
			else {

				window.setScene(introScene2);
			}

			});
		//intro scene 2
		intro2 = new Text();
		intro2.setText("As you finish carving your name into the stele, you hear a mad cackle ring out in your mind."
				+ "\nAHAHAHA!! Foolish adventurer! The world has forgotten the name of Malakor the mad for far too long!"
				+ "\nYou will once more come to fear my Twisted Tower!");
		intro2.setTextAlignment(TextAlignment.JUSTIFY);
		//continue to next scene
		continuebtn = new Button("Continue");
		continuebtn.setOnAction(e -> window.setScene(introScene3));
		//intro scene 3;
		intro3 = new Text();
		intro3.setText("You awaken, groggy and bleary eyed, only to find yourself in a dark room, with only one path forward."
				+ "\nBefore you get up and venture forth, you reach over to make sure your trusty... Your trusty..."
				+ "\nWhat exactly did you bring with you?"
				);
		itemQuestion = new Label("Was it your");
		itemQuestion2 = new Label("?");
		startingItem = new ChoiceBox<>();
		startingItem.getItems().addAll("chainmail", "staff", "cloak");
		startingItem.setValue("chainmail");
		continuebtn2 = new Button("Continue");
		continuebtn2.setOnAction(e -> window.setScene(introScene4));
		//exit scene, intro scene 4
		intro4 = new Text("Ah! So it was the "+startingItem.getValue()+". \nTake it, and conquer the tower.. if you can!!! AHAHAHA!!");
		continuebtn4 = new Button("Enter the tower");
		continuebtn4.setOnAction(e -> {
			TreasureBox Treasures = new TreasureBox();
			Player Player = new Player(Treasures, nameInput.getText(), 10, 10, 10, startingItem.getValue());
			LaunchPad LaunchPad = new LaunchPad(window, scene, Treasures, Player);
			window.setScene(LaunchPad.getLaunchPad());
		});



		//layout------------------------------------
		//scene1
		grid1 = new GridPane();
		grid1.setPadding(new Insets(10,10,10,10));
		grid1.setVgap(5);
		grid1.add(intro1, 0, 0);
		grid1.add(nameInput, 0, 1);
		grid1.add(accept, 1, 1);
		introScene1 = new Scene(grid1, 600, 100);
		//scene2
		vbox2 = new VBox();
		vbox2.getChildren().addAll(intro2, continuebtn);
		vbox2.setPadding(new Insets(10,10,10,10));
		vbox2.setSpacing(5);
		vbox2.setAlignment(Pos.CENTER);
		introScene2 = new Scene(vbox2, 600, 100);
		//scene3
		hbox3 = new HBox(5, itemQuestion, startingItem, itemQuestion2);
		hbox3.setAlignment(Pos.CENTER);
		vbox3 = new VBox();
		vbox3.getChildren().addAll(intro3, hbox3, continuebtn2);
		vbox3.setPadding(new Insets(10,10,10,10));
		vbox3.setSpacing(5);
		vbox3.setAlignment(Pos.CENTER);
		introScene3 = new Scene(vbox3, 600, 130);
		//exitscene, scene4
		vbox4 = new VBox();
		vbox4.getChildren().addAll(intro4, continuebtn4);
		vbox4.setPadding(new Insets(10,10,10,10));
		vbox4.setSpacing(5);
		vbox4.setAlignment(Pos.CENTER);
		introScene4 = new Scene(vbox4, 340, 100);

	}
	//checks to see if name input has spaces, spaces mess up the hiscore file
	private boolean isName(String message){
		Pattern pattern = Pattern.compile("\\s");
		Matcher matcher = pattern.matcher(message);
		boolean found = matcher.find();
		if (!found){
			return true;
		}
		else {
			return false;
		}

	}

}
