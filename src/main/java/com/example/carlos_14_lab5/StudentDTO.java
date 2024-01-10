package com.example.carlos_14_lab5;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentDTO {
    private final StringProperty id;
    private final DoubleProperty gpa1;
    private final DoubleProperty gpa2;
    private final DoubleProperty gpa3;
    private final DoubleProperty cgpa;

    public StudentDTO(String id, double gpa1, double gpa2, double gpa3, double cgpa){
        this.id = new SimpleStringProperty(id);
        this.gpa1 = new SimpleDoubleProperty(gpa1);
        this.gpa2 = new SimpleDoubleProperty(gpa2);
        this.gpa3 = new SimpleDoubleProperty(gpa3);
        this.cgpa = new SimpleDoubleProperty(cgpa);
    }

    public StudentDTO(String id, double gpa1, double gpa2, double gpa3){
        this.id = new SimpleStringProperty(id);
        this.gpa1 = new SimpleDoubleProperty(gpa1);
        this.gpa2 = new SimpleDoubleProperty(gpa2);
        this.gpa3 = new SimpleDoubleProperty(gpa3);
        this.cgpa = new SimpleDoubleProperty(StudentService.getCGPA(gpa1, gpa2, gpa3));
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public double getGpa1() {
        return gpa1.get();
    }

    public DoubleProperty gpa1Property() {
        return gpa1;
    }

    public double getGpa2() {
        return gpa2.get();
    }

    public DoubleProperty gpa2Property() {
        return gpa2;
    }

    public double getGpa3() {
        return gpa3.get();
    }

    public DoubleProperty gpa3Property() {
        return gpa3;
    }

    public double getCgpa() {
        return cgpa.get();
    }

    public DoubleProperty cgpaProperty() {
        return cgpa;
    }
}
