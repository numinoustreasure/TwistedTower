import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



class HiScoreMenu {

	TableColumn<HiScore, String> nameColumn;
	TableColumn<HiScore, Number> scoreColumn;
	TableView<HiScore> table;
	VBox tableBox;
	Stage window;
	Scene scene;
//this constructs the hiscoremenu from HiScores.txt
	HiScoreMenu(){
		//window and table initialization
		window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("HiScore");
    	table = new TableView<HiScore>();
    	//name column
    	nameColumn = new TableColumn<HiScore, String>("Name");
    	nameColumn.setMinWidth(60);
    	nameColumn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getName()));
    	//score column
    	scoreColumn = new TableColumn<HiScore, Number>("Score");
    	scoreColumn.setMinWidth(60);
    	scoreColumn.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getScore()));
    	//load score into t
    	getHiScoresFromFile();
    	table.getColumns().addAll(nameColumn, scoreColumn);
    	tableBox = new VBox();
    	tableBox.getChildren().addAll(table);
    	scoreColumn.setSortType(TableColumn.SortType.DESCENDING);
    	table.getSortOrder().add(scoreColumn);
    	scoreColumn.setSortable(true);
    	scene = new Scene(tableBox, 250, 300);
	}

	//display hiscore in popup window
	public void display(){
		window.setScene(scene);
		window.showAndWait();
	}
	//loads table from text file
	public void getHiScoresFromFile() {
	    try {

	        BufferedReader reader = new BufferedReader(new FileReader(new File("HiScore.txt")));
	        String line;
            String[] tokens;


	        while ((line = reader.readLine()) != null){
	            tokens = line.split(" ");
	            table.getItems().add(new HiScore(Integer.parseInt(tokens[0]), tokens [1]));
	        }

	        reader.close();

	    } catch (Exception ex){

	        ex.printStackTrace();

	    }
	}
}

