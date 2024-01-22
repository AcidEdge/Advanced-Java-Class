/*
Mark Witt
CSD-420
Module 10 Assignment
This Java file is the main, and handles all of the GUI parts of the application.
MySQL settings, as required:
database: databasedb
username: student1
password: pass
table: fans
fields: ID, firstname, lastname, favoriteteam
*/
package markwitt_module_10;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Markwitt_module_10 extends Application{

    //override main method and start application
    @Override
    public void start(Stage stage) throws ClassNotFoundException, SQLException{
        //setup program variables
        String firstName = "";
        String lastName = "";
        String team = "";
        
        //create boxes:
        VBox btnBox = new VBox();
        VBox resultBox = new VBox(20);
        HBox titleBox = new HBox();
        HBox directionsBox = new HBox();
        
        //setup title box:
        Text labelText = new Text("Search 'fans' table from databasedb:");
        labelText.setFill(Color.BLACK);
        labelText.setFont(Font.font(null, FontWeight.SEMI_BOLD, 20));
        titleBox.setPadding(new Insets(10,10,10,10));
        titleBox.getChildren().add(labelText);
        titleBox.setAlignment(Pos.CENTER);
        
        //setup directions text box
        Text directionText = new Text("Enter ID to search.");
        directionText.setFill(Color.BLACK);
        directionText.setFont(Font.font(null, FontWeight.SEMI_BOLD, 20));
        directionsBox.setPadding(new Insets(10,10,10,10));
        directionsBox.getChildren().add(directionText);
        directionsBox.setAlignment(Pos.CENTER);
        
        //setup buttons box
        Button searchBtn = new Button("Search Entries");
        Button updateBtn = new Button("Update Record");
        Button saveBtn = new Button("Save");
        searchBtn.setPrefWidth(100);
        updateBtn.setPrefWidth(100);
        saveBtn.setPrefWidth(100);
        btnBox.setAlignment(Pos.CENTER_LEFT);
        btnBox.getChildren().addAll(searchBtn, updateBtn);
        btnBox.setSpacing(10);
                
        //setup results box
        TextField id = new TextField();
        //id.setMaxWidth(50);
        Label idI = new Label("ID:");
        Label idF = new Label("First Name:");
        Label idL = new Label("Last Name:");
        Label idT = new Label("Favorite Team:");
        TextField textFirstName = new TextField(firstName);
        TextField textLastName = new TextField(lastName);
        TextField textTeam = new TextField(team);
        HBox hb1 = new HBox();
        HBox hb2 = new HBox();
        HBox hb3 = new HBox();
        HBox hb4 = new HBox();
        HBox hb5 = new HBox();
        hb1.getChildren().addAll(idI, id);
        hb1.setSpacing(75);
        hb2.getChildren().addAll(idF, textFirstName);
        hb2.setSpacing(30);
        hb3.getChildren().addAll(idL, textLastName);
        hb3.setSpacing(32);
        hb4.getChildren().addAll(idT, textTeam);
        hb4.setSpacing(14);
        resultBox.getChildren().addAll(hb1, hb2, hb3, hb4, hb5);
        resultBox.setPadding(new Insets(20, 20, 20, 20));
        resultBox.setAlignment(Pos.CENTER);   
        
        //create overall pane and add boxes to pane
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setTop(titleBox);
        pane.setLeft(btnBox);
        //pane.setRight(checkBox);
        pane.setCenter(resultBox);
        pane.setBottom(directionsBox);
        pane.setPrefSize(450, 275);
        //set scene & stage
        Scene scene = new Scene(pane);
        stage.setTitle("Module 10 Assignment - Mark Witt");
        stage.setScene(scene);
        stage.show();
        
        //event handler for search button
        searchBtn.setOnAction((ActionEvent e) -> {
            if (id.getText() != null && !id.getText().isEmpty()){
                try {
                    //get id from input and search results
                    String idString = id.getText();
                    getResults myResults = new getResults(idString);
                    
                    //output results, in terminal and in GUI
                    System.out.println("\nID: " + myResults.idResult);
                    textFirstName.setText(myResults.firstName);
                    System.out.println(myResults.firstName);
                    textLastName.setText(myResults.lastName);
                    System.out.println(myResults.lastName);
                    textTeam.setText(myResults.team);
                    System.out.println(myResults.team);
                    //if id is found during search, updates bottom text
                    if (myResults.idResult != null){
                        directionText.setText("Search Results Found For ID: " + myResults.idResult);
                    }
                    //if id is NOT found during search, updates bottom text - tells user to update records
                    else {
                        directionText.setText("Error: ID not Found. Please update records.");
                    }
                }
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Markwitt_module_10.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //if an id is not entered before pressing search
            } else {
                directionText.setText("Error: Please enter an ID.");
            }
        });
        
        //update button handler
        updateBtn.setOnAction((ActionEvent e) -> {
            //if id is not empty, save input values and update record
            if (id.getText() != null && !id.getText().isEmpty()){
                String newId = id.getText();
                String newFirst = textFirstName.getText();
                String newLast = textLastName.getText();
                String newTeam = textTeam.getText();
                getResults.update(newId, newFirst, newLast, newTeam);
                directionText.setText("Record Updated.");
                //if an id is not entered before pressing update
            } else {
                directionText.setText("Error: Please enter an ID.");
            }
        });
    }
    
    //main method, launch application
    public static void main(String[] args) {
        Application.launch(args);
    }
}