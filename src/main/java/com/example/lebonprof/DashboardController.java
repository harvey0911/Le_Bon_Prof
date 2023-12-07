package com.example.lebonprof;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.util.List;

public class DashboardController {
    @FXML
    private TableView<Person> Person_table;


    @FXML
    private TableColumn<Person, Integer> idc;

    @FXML
    private TableColumn<Person, String> first_namec;

    @FXML
    private TableColumn<Person, String> last_namec;


    @FXML
    private TableColumn<Person, String> emailc;

    @FXML
    private TableColumn<Person, String> contactNumberc;



    @FXML
    public void initialize() {
        // Initialize the TableView columns and associate them with the com.example.lebonprof.Student properties
        idc.setCellValueFactory(new PropertyValueFactory<>("id"));
        first_namec.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_namec.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactNumberc.setCellValueFactory(new PropertyValueFactory<>("phone_number"));




    }

   public void Display_students(){
        List<Person> studentsData = PostgresqlConnection.fetchStudentsFromDatabase();
        ObservableList<Person> studentsObservableList = FXCollections.observableArrayList(studentsData);
       Person_table.setItems(studentsObservableList);
    }

    public void Display_Professors(){
        List<Person> ProfessorData = PostgresqlConnection.fetchProfessorsFromDatabase();
        ObservableList<Person> studentsObservableList = FXCollections.observableArrayList(ProfessorData);
        Person_table.setItems(studentsObservableList);
    }



    public void Display_parents(){
        List<Person> ParentsData = PostgresqlConnection.fetchParentsFromDatabase();
        ObservableList<Person> studentsObservableList = FXCollections.observableArrayList(ParentsData);
        Person_table.setItems(studentsObservableList);
    }






    }









