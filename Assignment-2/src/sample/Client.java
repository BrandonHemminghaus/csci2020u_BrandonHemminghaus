package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.File;

public class Client extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("File Sharer v1.0");
        primaryStage.setScene(new Scene(root, 600, 400));

        //Grid for the buttons
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);

        ListView clientList = new ListView(); //Listview for the client
        ListView serverList = new ListView(); //Listview for the server


        //2 buttons
        Button downloadbutton = new Button("Download");
        downloadbutton.setPrefWidth(100);
        Button uploadbutton = new Button("Upload");
        uploadbutton.setPrefWidth(100);

        //Adding the buttons to the grid on the top left
        grid.add(downloadbutton, 0,0);
        grid.add(uploadbutton, 1,0);

        //Client and server folder paths
        String path = "C:\\csci2020u\\Assignment-2\\src\\sample\\Client\\Client.txt";
        String path2 = "C:\\csci2020u\\Assignment-2\\src\\sample\\Server\\Server.txt";

        //Make the string path in a file path
        File file1 = new File(path);
        File file2 = new File(path2);

        clientList.getItems().add(file1.getName());//Add to client list
        serverList.getItems().add(file2.getName());//Add to server list

        //Adds the 2 lists horizontally to each other
        HBox hBox = new HBox(clientList,serverList);

        //Adds the lists under the grid with the buttons
        VBox vbox = new VBox(grid,hBox);

        //New scene to display everything
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);

        downloadbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        uploadbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });

        primaryStage.show();
    }
}
