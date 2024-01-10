package com.example.carlos_14_lab5;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final String id;
    private final double gpa1;
    private final double gpa2;
    private final double gpa3;

    public Student(String id, double gpa1, double gpa2, double gpa3){
        this.id = id;
        this.gpa1 = gpa1;
        this.gpa2 = gpa2;
        this.gpa3 = gpa3;
    }

    public String getId() {
        return id;
    }

    public double getGpa1() {
        return gpa1;
    }

    public double getGpa2() {
        return gpa2;
    }

    public double getGpa3() {
        return gpa3;
    }
}
