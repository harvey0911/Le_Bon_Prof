package com.example.lebonprof;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.Statement;
public class SignUpController {


    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField f_nameField;

    @FXML
    private TextField l_nameField;
    static String f_name;
    static String l_name;
    static String Email;
    static String password;
    @FXML
    private TextField EmailField;

    @FXML
    private TextField CountryField;

    @FXML
    void Register() {


        f_name=f_nameField.getText();
        l_name= l_nameField.getText();
        Email=EmailField.getText();
        password= passwordField.getText();

    }
}
