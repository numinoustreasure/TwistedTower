import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NameAlert {

	//creates and displays a popup based on parameters passed. this is used for invalid input alerts
	public static void display(String title, String message){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		Label label = new Label(message);
		Button close = new Button("Close");
		close.setOnAction(e -> window.close());
		label.setWrapText(true);
		label.setMaxWidth(280);
		label.setAlignment(Pos.CENTER);
		close.setAlignment(Pos.CENTER);
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, close);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 300, 90);
		window.setScene(scene);
		window.showAndWait();
	}
}
