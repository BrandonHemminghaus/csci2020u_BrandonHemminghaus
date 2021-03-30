package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main extends Application {
    private int width = 800;
    private int height = 600;
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(canvas);
        primaryStage.setTitle("lab 09: Stock Performance");
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
        drawLinePlot(downloadStockPrices("GOOG"),downloadStockPrices("AAPL"));
    }

    public static double[] downloadStockPrices(String stockTicket){
        ArrayList<String> list = new ArrayList<>();
        String path = "https://query1.finance.yahoo.com/v7/finance/download/";
        String other = "?period1=1262322000&period2=1451538000&interval=1mo&events=history&includeAdjustedClose=true";
        try {
            URL url = new URL(path + stockTicket + other);
            FileReader fileReader = new FileReader(url.getFile());
            BufferedReader input = new BufferedReader(fileReader);
            String line;
            while((line = input.readLine()) != null){
                String data[];
                data = line.split(",");
                list.add(data[4]);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new double[]{0.0};
    }

    public void drawLinePlot(double[] list_1, double[] list_2){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(50,height-50,width-50,height-50);
        gc.strokeLine(50,height-50,50,50);
        plotLine(list_1,Color.RED);
        plotLine(list_2,Color.BLUE);
    }

    public void plotLine(double[] list, Color color){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(color);
        gc.setFill(color);
        //gc.strokeLine();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
