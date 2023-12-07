package com.example.lebonprof;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static com.example.lebonprof.SecondSceneController.stage;

public class LoginController {
    @FXML
    private PasswordField passwordField;
@FXML
    private  TextField usernameField;
static String username;
static String password;
    public void Login(ActionEvent event) throws IOException {
boolean loggedin;
        username=usernameField.getText();
       password=passwordField.getText();
        loggedin=PostgresqlConnection.Login_Trial(username,password);

        if (loggedin) {
            try{
                FXMLLoader loader = new FXMLLoader(LeBonProf.class.getResource("/com/example/lebonprof/SignUp.fxml"));

                Parent root = loader.load();
                Stage stage  = (Stage) usernameField.getScene().getWindow();
                stage.setScene(new Scene(root));
            }catch (IOException e){
                throw  new RuntimeException(e);
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Nom d'utilisateur ou mot de passe incorrect");
            alert.showAndWait();
        }


    }


}