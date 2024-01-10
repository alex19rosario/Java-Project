package com.example.carlos_14_lab5;

import java.util.function.Function;

public class StudentService {
    private static Function<Student, Double> getCGPA = s -> Math.ceil(((s.getGpa1() + s.getGpa2() + s.getGpa3())/3) * 10)/10;

    public static double getCGPA(Student student){
        return getCGPA.apply(student);
    }

    public static double getCGPA(double gpa1, double gpa2, double gpa3){
        return Math.ceil(((gpa1 + gpa2 + gpa3)/3) * 10)/10;
    }
}
