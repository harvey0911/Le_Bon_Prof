package com.example.lebonprof;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.lebonprof.SecondSceneController.stage;

//import static com.example.lebonprof.SecondSceneController.Dashboard;


public class PostgresqlConnection {
    
    
    static Connection connection;
    static Statement statement;

    public PostgresqlConnection() {

        try {
            String url = "jdbc:postgresql://localhost:5432/lebonprofdb";
            String user = "user2";
            String password = "aymane";

            // Create the connection

             connection = DriverManager.getConnection(url, user, password);
             statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public  static void Register(String f_name,String l_name,String Email ,String contact_number,String status,String subject){

        new PostgresqlConnection();

        String query = "INSERT INTO person ( first_name, last_name, phone_number, email, status) " + "VALUES ( '" + f_name + "', '" + l_name + "', '" + contact_number + "', '" + Email + "','" + status + "' )";
        int person_id;
        int subject_id;

        int rowsAffected = 0;
        try {
            rowsAffected = statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (rowsAffected > 0) {
            System.out.println("Record inserted successfully!");
             person_id= fetch_person_id( f_name, l_name, Email , contact_number, status, subject);
             subject_id=fetch_subject_id(subject);
            add_course(person_id,subject_id);
            System.out.println("subject linking inserted successfully!");

        } else {
            System.out.println("Failed to insert record!");
        }
        Disconnect();
    }

public static  void add_course(int person_id,int subject_id){

        new PostgresqlConnection();

    String query=" INSERT INTO person_subject (person_id,subject_id)"+ "VALUES('"+ person_id+"','"+subject_id+"')";

    int rowsAffected = 0;
    try {
        rowsAffected = statement.executeUpdate(query);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    Disconnect();
}

public static int fetch_person_id(String f_name,String l_name,String Email ,String contact_number,String status,String subject) {

    new PostgresqlConnection();


    String query = "SELECT id FROM person WHERE first_name = '"+f_name+"' AND last_name = '"+l_name+"' AND email ='"+Email+"'  AND phone_number = '"+contact_number+"' AND status = '"+status+"'";

    int person_id;
    try (ResultSet resultSet = statement.executeQuery(query)) {
        resultSet.next();
        person_id = resultSet.getInt("id");


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    Disconnect();
    return person_id;
}
    public static int fetch_subject_id(String subject){
        new PostgresqlConnection();

        String query = "SELECT * FROM subject WHERE subject_name='" + subject + "'";

        int subject_id = -1; // Initialize subject_id to a default value (e.g., -1) in case the query doesn't return any rows
        try (ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) { // Check if there's a row available
                subject_id = resultSet.getInt("subject_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Disconnect();
        return subject_id;
    }


    public static Boolean Login_Trial(String username, String upassword){

        new PostgresqlConnection();
Boolean loggedIn;

        String query = "SELECT * FROM Authentication WHERE username='" + username +"'";

        try (ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                String dbusername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");

                loggedIn = dbusername.equals(username) && dbPassword.equals(upassword);

            }else{
                loggedIn=false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Disconnect();
        return loggedIn;
    }
    public static List<Person> fetchStudentsFromDatabase(){


        new PostgresqlConnection();

        String query = "SELECT * FROM person where status = 'S' ";

        List<Person> studentList= new ArrayList<>();

        try (ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {

                int id=resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email= resultSet.getString("email");
                String contactNumber= resultSet.getString("phone_number");




                // Create a com.example.lebonprof.Student instance and add it to the TableView

                Person person = new Person( id,  first_name, last_name,  email, contactNumber);
                studentList.add(person);

                //DashboardController.getStudentsTable().getItems().add(student);


            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        Disconnect();
        return studentList;
    }

    public static List<Person> fetchProfessorsFromDatabase(){



        new PostgresqlConnection();
        String query = "SELECT * FROM person where status = 'P' ";

        List<Person> studentList= new ArrayList<>();

        try (ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {

                int id=resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email= resultSet.getString("email");
                String contactNumber= resultSet.getString("phone_number");




                // Create a com.example.lebonprof.Student instance and add it to the TableView

                Person person = new Person( id,  first_name, last_name,  email, contactNumber);
                studentList.add(person);


            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        Disconnect();
        return studentList;
    }

    public static List<Person> fetchParentsFromDatabase(){



        new PostgresqlConnection();
        String query = "SELECT * FROM person where status = 'PS' ";

        List<Person> studentList= new ArrayList<>();

        try (ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {

                int id=resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email= resultSet.getString("email");
                String contactNumber= resultSet.getString("phone_number");




                // Create a com.example.lebonprof.Student instance and add it to the TableView

                Person person = new Person( id,  first_name, last_name,  email, contactNumber);
                studentList.add(person);


            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        Disconnect();
        return studentList;
    }



    public static List<Subject> fetchSubjectsFromDatabase(){



        new PostgresqlConnection();
        String query = "SELECT * FROM subject ";

        List<Subject> SubjectList= new ArrayList<>();

        try (ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {

                int id=resultSet.getInt("subject_id");
                String Subject_name = resultSet.getString("Subject_name");


                // Create a com.example.lebonprof.Student instance and add it to the TableView

                Subject subject = new Subject( Subject_name,id);
                SubjectList.add(subject);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        Disconnect();
        return SubjectList;
    }

   public static void Create_individual_session_DB(Person student, Person professor,Subject subject, LocalDate date, int salle){
       new PostgresqlConnection();

       String query = "INSERT INTO person_subject ( person_id, subject_id) " + "VALUES('"+ student.getId()+"','"+subject.getId()+"')";


       int rowsAffected = 0;
       try {
           rowsAffected = statement.executeUpdate(query);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       if (rowsAffected > 0) {
           System.out.println("Record inserted successfully!");
       } else {
           System.out.println("Failed to insert record!");
       }
       Disconnect();
    }

    public static void Disconnect(){

        try {
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
   

}

