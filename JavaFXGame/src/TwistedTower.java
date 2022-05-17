import javafx.application.Application;
import javafx.stage.Stage;
//this begins the game
public class TwistedTower extends Application {

	Stage window;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	window = primaryStage;
    	begin(window);

    }


    public void begin(Stage window){

    	StartMenu Start = new StartMenu(window);
    	window.setScene(Start.getScene());
    	window.setTitle("Twisted Tower");
    	window.show();
    }

}
