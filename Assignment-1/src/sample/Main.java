//Author: Brandon Hemminghaus
//Created on March 6, 2021
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Spam Master 3000");
        primaryStage.setScene(new Scene(root, 600, 600));

        TableView table = new TableView(); //Create the table

        //Creating the columns
        TableColumn<Testfile, String> column1 = new TableColumn<>("File"); //Filename
        column1.setCellValueFactory(new PropertyValueFactory<>("filename"));
        TableColumn<Testfile, String> column2 = new TableColumn<>("Actual class"); //Class folder
        column2.setCellValueFactory(new PropertyValueFactory<>("actualClass"));
        TableColumn<Testfile, String> column3 = new TableColumn<>("Spam Probability"); //Spam Probability of each file
        column3.setCellValueFactory(new PropertyValueFactory<>("spamProbability"));

        //Getting the columns for the table
        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);

        table.setItems(train.getAllInfo()); //Getting the info for the table
        table.setMinWidth(500); //Improvement I made to the layout
        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
