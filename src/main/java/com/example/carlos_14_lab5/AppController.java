package com.example.carlos_14_lab5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

public class AppController implements Initializable {

    @FXML private TextField tfStudentId;
    @FXML private Spinner<Double> spnGPA1 = new Spinner<>(0.0, 4.0, 0.1);
    @FXML private Spinner<Double> spnGPA2 = new Spinner<>(0.0, 4.0, 0.1);
    @FXML private Spinner<Double> spnGPA3 = new Spinner<>(0.0, 4.0, 0.1);
    @FXML private TableView<StudentDTO> tableView;
    @FXML private TableColumn<StudentDTO, String> columnId;
    @FXML private TableColumn<StudentDTO, Double> columnGPA1;
    @FXML private TableColumn<StudentDTO, Double> columnGPA2;
    @FXML private TableColumn<StudentDTO, Double> columnGPA3;
    @FXML private TableColumn<StudentDTO, Double> columnCGPA;
    private ObservableList<StudentDTO> studentList = FXCollections.observableArrayList();

    @FXML
    protected void save() {
        Student student = new Student(tfStudentId.getText(), spnGPA1.getValue(), spnGPA2.getValue(), spnGPA3.getValue());
        int rowInserted = StudentDAO.create(student);
        if(rowInserted > 0){
            StudentDTO dto = new StudentDTO(student.getId(), student.getGpa1(), student.getGpa2(), student.getGpa3(), StudentService.getCGPA(student));
            studentList.add(dto);
        }
    }

    protected void loadTable(){
        for(StudentDTO student: StudentDAO.findAll()){
            studentList.add(student);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnGPA1.setCellValueFactory(new PropertyValueFactory<>("gpa1"));
        columnGPA2.setCellValueFactory(new PropertyValueFactory<>("gpa2"));
        columnGPA3.setCellValueFactory(new PropertyValueFactory<>("gpa3"));
        columnCGPA.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
        tableView.setItems(studentList);
        loadTable();
        spnGPA1.setEditable(true);
        spnGPA2.setEditable(true);
        spnGPA3.setEditable(true);
    }
}