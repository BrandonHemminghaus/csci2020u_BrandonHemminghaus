package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 05 Solution");
        primaryStage.setScene(new Scene(root, 600, 400));

        TableView table = new TableView();
        TableColumn<StudentRecord, String> column1 = new TableColumn<>("SI");
        column1.setCellValueFactory(new PropertyValueFactory<>("SI"));
        TableColumn<StudentRecord, String> column2 = new TableColumn<>("Assignments");
        column2.setCellValueFactory(new PropertyValueFactory<>("Assignments"));
        TableColumn<StudentRecord, String> column3 = new TableColumn<>("Midterms");
        column3.setCellValueFactory(new PropertyValueFactory<>("Midterms"));
        TableColumn<StudentRecord, String> column4 = new TableColumn<>("FinalExam");
        column4.setCellValueFactory(new PropertyValueFactory<>("FinalExam"));
        TableColumn<StudentRecord, String> column5 = new TableColumn<>("FinalMark");
        column5.setCellValueFactory(new PropertyValueFactory<>("FinalMark"));
        TableColumn<StudentRecord, String> column6 = new TableColumn<>("LetterGrade");
        column6.setCellValueFactory(new PropertyValueFactory<>("LetterGrade"));

        table.getColumns().add(column1);
        table.getColumns().add(column2);
        table.getColumns().add(column3);
        table.getColumns().add(column4);
        table.getColumns().add(column5);
        table.getColumns().add(column6);

        table.setItems(DataSource.getAllMarks());
        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
