package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main extends Application {
    private Canvas canvas;
    private int Flash_Flood = 0;
    private int Severe_Thunderstorm = 0;
    private int Special_Marine = 0;
    private int Tornado = 0;
    private int total = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(canvas);
        primaryStage.setTitle("lab06");
        primaryStage.setScene(new Scene(root, 800, 600));

        String path = "C:\\csci2020u\\lab07\\src\\sample\\weatherwarnings-2015.csv";
        FileReader fileReader = new FileReader(path);
        BufferedReader input = new BufferedReader(fileReader);
        String line = null;
        while ((line = input.readLine()) != null) {
            String[] col = line.split("|");
            for (int i = 0; i < col[5].length(); i++) {
                if (col[5] == "FLASH FLOOD") {
                    Flash_Flood++;
                    total++;
                } else if (col[5] == "SEREVE THUNDERSTORM") {
                    Severe_Thunderstorm++;
                    total++;
                } else if (col[5] == "SPEICAL MARINE") {
                    Special_Marine++;
                    total++;
                } else if (col[5] == "TORNADO") {
                    Tornado++;
                    total++;
                }
            }
        }
        primaryStage.show();
        draw(root);
    }

    public void draw(Group root) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.LIGHTBLUE);
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(20,20,40,30);
        //gc.strokeArc(500,200,200,200, 115.0, (Flash_Flood/total)*360.0, ArcType.ROUND);
        //gc.fillArc(500,200,200,200, 115.0, (Flash_Flood/total)*360.0, ArcType.ROUND);

        gc.setStroke(Color.YELLOW);
        gc.setFill(Color.YELLOW);
        gc.fillRect(20,60,40,30);
        //gc.strokeArc(500,200,200,200, 115.0, (Severe_Thunderstorm/total)*360.0, ArcType.ROUND);
        //gc.fillArc(500,200,200,200, 115.0, (Severe_Thunderstorm/total)*360.0, ArcType.ROUND);

        gc.setStroke(Color.ORANGE);
        gc.setFill(Color.ORANGE);
        gc.fillRect(20,100,40,30);
        //gc.strokeArc(500,200,200,200, 115.0, (Special_Marine/total)*360.0, ArcType.ROUND);
        //gc.fillArc(500,200,200,200, 115.0, (Special_Marine/total)*360.0, ArcType.ROUND);

        gc.setStroke(Color.PINK);
        gc.setFill(Color.PINK);
        gc.fillRect(20,140,40,30);
        //gc.strokeArc(500,200,200,200, 115.0, (Tornado/total)*360.0, ArcType.ROUND);
        //gc.fillArc(500,200,200,200, 115.0, (Tornado/total)*360.0, ArcType.ROUND);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
