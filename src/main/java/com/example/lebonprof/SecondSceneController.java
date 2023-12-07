package com.example.lebonprof;

import java.io.IOException;
import java.sql.Statement;
import java.util.EventObject;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class SecondSceneController {
    public static Stage stage;
    public  Parent root;
    public  Scene scene;

    @FXML
    private Pane panel;
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button aboutusbutton;

    @FXML
    private Button contactbutton;

    @FXML
    private Button ourbooksbutton;

    @FXML
    private Button loginbutton;

    @FXML
    private Button signupbutton;

    @FXML
    private void aboutusclick() {
        // Handle About Us button click event
    }

    @FXML
    private void contactclick() {
        // Handle Contact button click event
    }




   /* @FXML
   public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LeBonProf.class.getResource("/com/example/lebonprof/SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("SignUp");
        stage.setScene(scene);
        stage.show();

    }*/

    @FXML
    static void login_click(ActionEvent event ) throws IOException {
        // Handle Login button click event
        FXMLLoader fxmlLoader = new FXMLLoader(LeBonProf.class.getResource("/com/example/lebonprof/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }




    @FXML
    public static void Dashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LeBonProf.class.getResource("/com/example/lebonprof/Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }




}
