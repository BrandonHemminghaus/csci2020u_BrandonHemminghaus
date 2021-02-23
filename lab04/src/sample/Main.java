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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 04 solution");
        primaryStage.setScene(new Scene(root, 600, 400));

        //Grid layout
        GridPane theGrid = new GridPane();
        theGrid.setAlignment(Pos.TOP_LEFT);
        theGrid.setHgap(10);
        theGrid.setVgap(10);
        theGrid.setPadding(new Insets(25,25,25,25));

        //scene layout
        Scene theScene = new Scene(theGrid, 600,400);
        primaryStage.setScene(theScene);

        //create UI controls
        Label lb_username = new Label("Username:");
        Label lb_password = new Label("Password:");
        Label lb_fullname = new Label("Full Name:");
        Label lb_email = new Label("E-mail:");
        Label lb_phonenumber = new Label("Phone #:");
        Label lb_dateofbirth = new Label("Date of Birth:");

        //Inputs
        TextField txf_username = new TextField();
        PasswordField pf_password = new PasswordField();
        TextField txf_fullname = new TextField();
        TextField txf_email = new TextField();
        TextField txf_phonenumber = new TextField();
        DatePicker dp_dateofbirth = new DatePicker();

        //Add the UI components onto the grid

        //username
        theGrid.add(lb_username,0,0);
        theGrid.add(txf_username,1,0);

        //password
        theGrid.add(lb_password,0,1);
        theGrid.add(pf_password,1,1);

        //full name
        theGrid.add(lb_fullname,0,2);
        theGrid.add(txf_fullname,1,2);

        //email
        theGrid.add(lb_email,0,3);
        theGrid.add(txf_email,1,3);

        //phone
        theGrid.add(lb_phonenumber,0,4);
        theGrid.add(txf_phonenumber,1,4);

        //date
        theGrid.add(lb_dateofbirth,0,5);
        theGrid.add(dp_dateofbirth,1,5);

        //button
        Button button = new Button("Register");
        HBox hb_button = new HBox(10);
        hb_button.setAlignment(Pos.CENTER_LEFT);
        hb_button.getChildren().add(button);
        theGrid.add(hb_button,1,6);

        //button action
        final TextField action_username = new TextField();
        theGrid.add(action_username,1,0);
        final PasswordField action_password = new PasswordField();
        theGrid.add(action_password,1,1);
        final TextField action_fullname = new TextField();
        theGrid.add(action_fullname,1,2);
        final TextField action_email = new TextField();
        theGrid.add(action_email,1,3);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                action_username.setText("Shirou");
                action_password.setText("Hello world");
                action_fullname.setText("Brandon Hemminghaus");
                action_email.setText("BrandonH@FakeEmail.com");
            }
        });

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
