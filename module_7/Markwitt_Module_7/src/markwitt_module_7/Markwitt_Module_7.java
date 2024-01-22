/*
Mark witt
CSD-420
Module 7 Assignment
4/15/23
*/
package markwitt_module_7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Markwitt_Module_7 extends Application {
    @Override
    public void start(Stage primaryStage){
        //setup overall layout, and link css sheet
        HBox hbox = new HBox();
        Scene scene = new Scene(hbox, 320, 250);
        scene.getStylesheets().add(Markwitt_Module_7.class.getResource("markwitt_style.css").toExternalForm());
        
        //setup circles
        Circle circle1 = new Circle(40, 125, 30);
        Circle circle2 = new Circle(40, 125, 30);
        Circle circle3 = new Circle(120, 125, 30);
        Circle circle4 = new Circle(200, 125, 30);
        
        //add css attributes to circles
        circle1.getStyleClass().add("plaincircle");
        circle2.getStyleClass().addAll("plaincircle", "circleborder");
        circle3.setId("redcircle");
        circle4.setId("greencircle");
        
        //create pane for first circle, adds border to the pane
        Pane pane1 = new Pane();
        pane1.getChildren().addAll(circle1);
        pane1.getStyleClass().add("border");
        
        //create second pane for remaining 3 circles, no border
        Pane pane2 = new Pane();
        pane2.getChildren().addAll(circle2, circle3, circle4);

        //add panes to hbox, set and show stage
        hbox.getChildren().add(pane1);
        hbox.getChildren().add(pane2);
        primaryStage.setTitle(" Mark Witt Module 7");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
        public static void main(String[] args) {
        Application.launch(args);
    }
    
}
