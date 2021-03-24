package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public String currentFilename = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 08 Solution");
        primaryStage.setScene(new Scene(root, 600, 400));

        Menu file = new Menu("File");
        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Save_as = new MenuItem("Save as");
        MenuItem Exit = new MenuItem("Exit");

        file.getItems().add(New);
        file.getItems().add(Open);
        file.getItems().add(Save);
        file.getItems().add(Save_as);
        file.getItems().add(Exit);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(file);

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

        GridPane theGrid = new GridPane();
        theGrid.setAlignment(Pos.BOTTOM_LEFT);
        theGrid.setHgap(10);
        theGrid.setVgap(10);
        theGrid.setPadding(new Insets(25,25,25,25));

        Label lb_SID = new Label("SID:");
        Label lb_Assignemnt = new Label("Assignment:");
        Label lb_Midterm = new Label("Midterm:");
        Label lb_FinalExam = new Label("Final Exam:");

        TextField txf_SID = new TextField();
        TextField txf_Assignment = new TextField();
        TextField txf_Midterm = new TextField();
        TextField txf_FinalExam = new TextField();

        theGrid.add(lb_SID,0,0);
        theGrid.add(txf_SID,1,0);

        theGrid.add(lb_Midterm,0,1);
        theGrid.add(txf_Midterm,1,1);

        theGrid.add(lb_Assignemnt,2,0);
        theGrid.add(txf_Assignment,3,0);

        theGrid.add(lb_FinalExam,2,1);
        theGrid.add(txf_FinalExam,3,1);

        Button button = new Button("Add");
        HBox hb_button = new HBox(10);
        hb_button.setAlignment(Pos.BOTTOM_LEFT);
        hb_button.getChildren().add(button);
        theGrid.add(hb_button,0,2);

        VBox vbox = new VBox(menuBar,table,theGrid);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);


        New.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                table.getItems().clear();
            }
        });

        Open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                table.setItems(DataSource.getAllMarks());
            }
        });

        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

        primaryStage.show();
    }

    public void save(){
    }

    public void load(){
    }

    public static void main(String[] args) {
        launch(args);
    }
}
