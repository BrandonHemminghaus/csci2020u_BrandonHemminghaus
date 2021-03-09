package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

public class Main extends Application {
    private Canvas canvas;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        canvas = new Canvas();
        canvas.widthProperty().bind(primaryStage.widthProperty());
        canvas.heightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(canvas);
        primaryStage.setTitle("lab06");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
        draw(root);
    }

    private void draw(Group root) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);
        int x = 10;
        double new_x = 100/8;
        double maxVal = Double.NEGATIVE_INFINITY;
        double minVal = Double.MAX_VALUE;

        for(int i = 0; i < avgHousingPricesByYear.length; i++){
            if(avgHousingPricesByYear[i] > maxVal){
                maxVal = avgHousingPricesByYear[i];
            }
            if(avgHousingPricesByYear[i] < minVal){
                minVal = avgHousingPricesByYear[i];
            }
        }
        for(int i = 0; i < avgHousingPricesByYear.length; i++){
            double height = ((avgHousingPricesByYear[i]-minVal) / (maxVal - minVal)) * 300;
            gc.fillRect(x,300-height,new_x,height);
            x += 2*new_x;
        }

        gc.setStroke(Color.BLUE);
        gc.setFill(Color.BLUE);
        int y = 20;
        for(int i = 0; i < avgCommercialPricesByYear.length; i++){
            if(avgCommercialPricesByYear[i] > maxVal){
                maxVal = avgCommercialPricesByYear[i];
            }
            if(avgCommercialPricesByYear[i] < minVal){
                minVal = avgCommercialPricesByYear[i];
            }
        }
        for(int i = 0; i < avgCommercialPricesByYear.length; i++){
            double height = ((avgCommercialPricesByYear[i]-minVal) / (maxVal - minVal)) * 300;
            gc.fillRect(y,300-height,new_x,height);
            y += 2*new_x;
        }
    }

    private static double[] avgHousingPricesByYear = { 247381.0,264171.4,287715.3,294736.1, 308431.4,322635.9,340253.0,363153.7};
    private static double[] avgCommercialPricesByYear = { 1121585.3,1219479.5,1246354.2,1295364.8, 1335932.6,1472362.0,1583521.9,1613246.3};
    private static String[] ageGroups = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = { 648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};


    public static void main(String[] args) {
        launch(args);
    }
}
