package com.example.lebonprof;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import static com.example.lebonprof.SecondSceneController.login_click;

public class SignUpController {

    @FXML
    private Scene scene;


        @FXML
        private ChoiceBox<Subject> choiceBox;

        @FXML
        private ChoiceBox<Subject> choiceBox1;

        @FXML
        private ChoiceBox<Person> choiceBox_students;
        @FXML
        private ChoiceBox<Person> choiceBox_professors;

        @FXML
        private DatePicker mydatepicker;

        @FXML
        private ListView<PrivateSession> past_sessions;

        @FXML
        private ListView<PrivateSession> future_sessions;

        @FXML
        private ListView<PrivateSession> future_individual_sessions;

        private Stack<PrivateSession> stack = new Stack<>();
        @FXML
        private ListView<PrivateSession> past_individual_sessions;


    @FXML
    private TableView<Person> Person_table;

    @FXML
    private TextField f_nameField;

    @FXML
    private TextField l_nameField;

    @FXML
    private TextField EmailField;

    @FXML
    private TextField contactField;


    public static String f_name;
    public static String l_name;
    public static String Email;
    public static String password;

    public static String contact_number;

    public static String Subject;


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


        List<Subject> subjects = PostgresqlConnection.fetchSubjectsFromDatabase();
        //ObservableList<Subject> subjectObservableList = FXCollections.observableArrayList(studentsData);
        //choiceBox.setItems(subjectObservableList);


        // Add subjects to the ChoiceBox
        //List<Subject> subjects = PostgresqlConnection.fetchSubjectsFromDatabase();
        choiceBox.getItems().addAll(subjects);
        choiceBox1.getItems().addAll(subjects);

        // Set the cell factory for multiple selections
        //choiceBox.setCellFactory(CheckBoxListCell.forListView(Subject::selectedProperty));
        //choiceBox.setButtonCell(new ListCell<>()); // Optional: Use an empty cell for the default button appearance

        List<Person> professors = PostgresqlConnection.fetchProfessorsFromDatabase();
        choiceBox_professors.getItems().addAll(professors);

        List<Person> students = PostgresqlConnection.fetchStudentsFromDatabase();
        choiceBox_students.getItems().addAll(students);

        idc.setCellValueFactory(new PropertyValueFactory<>("id"));
        first_namec.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        last_namec.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        emailc.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactNumberc.setCellValueFactory(new PropertyValueFactory<>("phone_number"));


    }

    @FXML
    void Register_As_student() {
        f_name = f_nameField.getText();
        l_name = l_nameField.getText();
        Email = EmailField.getText();
        contact_number=contactField.getText();
        Subject= choiceBox.getValue().getSubject();

        PostgresqlConnection.Register( f_name, l_name, Email , contact_number,"S",Subject);
        initialize();
    }


    @FXML
    void Register_As_Professor(){
        f_name = f_nameField.getText();
        l_name = l_nameField.getText();
        Email = EmailField.getText();
        contact_number=contactField.getText();
        Subject=String.valueOf(choiceBox.getOnAction());
        PostgresqlConnection.Register(f_name, l_name, Email , contact_number,"P",Subject);

        initialize();

    }


    public void LoginUI(ActionEvent event){

        try {
            login_click(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void Create_individual_session() {
        LocalDate date = mydatepicker.getValue();
        Person student = choiceBox_students.getValue();
        Person professor = choiceBox_professors.getValue();
        com.example.lebonprof.Subject subject= choiceBox1.getValue();
        // Check if any ChoiceBox is empty
        if (date == null || student == null || professor == null || choiceBox1==null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
            return; // Exit the method, as the required values are not selected
        }

        PrivateSession privateSession = new PrivateSession(student, professor, date, 1,subject);



        if (date.isAfter(LocalDate.now())) {
            future_individual_sessions.getItems().add(privateSession);
            Sort_individual_session();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Impossible de programmer une session dans le passé.");
            alert.showAndWait();
        }

        PostgresqlConnection.Create_individual_session_DB(privateSession.getStudent(), privateSession.getProfessor(), privateSession.getSubject(),privateSession.getDate(),privateSession.getSalle());
    }

    @FXML
    void delete_individual_session(){
        int selected_id= future_individual_sessions.getSelectionModel().getSelectedIndex();

        stack.push(future_individual_sessions.getSelectionModel().getSelectedItem());

        future_individual_sessions.getItems().remove(selected_id);
    }




    @FXML
    void Sort_individual_session() {
        // Use a custom comparator to sort sessions by date in ascending order
        Comparator<PrivateSession> dateComparator = Comparator.comparing(PrivateSession::getDate);

        future_individual_sessions.getItems().sort(dateComparator);
    }


    @FXML
    void undo(){

        future_individual_sessions.getItems().add(stack.pop());
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


