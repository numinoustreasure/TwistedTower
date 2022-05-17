import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationCheck {

	//another popup, this one for close confirmation
	static boolean confirmation;
	public static void display(){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Are you sure?");
		Label label = new Label("Are you sure?");
		Button yes = new Button("Yes");
		Button no = new Button("No");
		yes.setOnAction(e -> {
			confirmation = true;
			window.close();
			});
		no.setOnAction(e ->{
			confirmation = false;
			window.close();
		});
		HBox btnlayout = new HBox(10, yes, no);
		btnlayout.setAlignment(Pos.CENTER);
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, btnlayout);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 250, 75);
		window.setScene(scene);
		window.showAndWait();
	}
}