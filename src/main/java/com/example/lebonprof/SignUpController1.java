/*package com.example.lebonprof;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField f_nameField;

    @FXML
    private TextField l_nameField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField CountryField;

    public static String f_name;
    public static String l_name;
    public static String Email;
    public static String password;

    public static String Country;



    @FXML
    void Register() {


        f_name = f_nameField.getText();
        l_name = l_nameField.getText();
        Email = EmailField.getText();
        password = passwordField.getText();
        Country= CountryField.getText();


        // Perform database insert operation here
        try {

            String url = "jdbc:postgresql://localhost:5432/test";
            String user = "user2";
            String pass = "aymane";

            // Create the connection
            Connection connection = DriverManager.getConnection(url, user, pass);

            // Create the SQL statement
            String query = "INSERT INTO student (id, first_name, last_name, email, password, country) " +
                    "VALUES (105803, '" + f_name + "', '" + l_name + "', '" + Email + "', '" + password + "', +country+ )";

            // Create the statement
            Statement statement = connection.createStatement();

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully!");
            } else {
                System.out.println("Failed to insert record!");
            }

            // Close the statement and connection
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
*/