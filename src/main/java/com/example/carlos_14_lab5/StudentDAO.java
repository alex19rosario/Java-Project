package com.example.carlos_14_lab5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static int create(Student student){
        int rowInserted = 0;
        try(Connection con = OracleDB.getDatabase().getSource().getConnection();
            PreparedStatement pst = con.prepareStatement("insert into student (studentId, gpa1, gpa2, gpa3) values (?, ?, ?, ?)")) {
            pst.setString(1, student.getId());
            pst.setDouble(2, student.getGpa1());
            pst.setDouble(3, student.getGpa2());
            pst.setDouble(4, student.getGpa3());
            rowInserted = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  rowInserted;
    }

    public static List<StudentDTO> findAll(){
        List<StudentDTO> list = new ArrayList<>();
        try(Connection con = OracleDB.getDatabase().getSource().getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student");
            ResultSet rs = pst.executeQuery()) {

            while(rs.next()){
                String studentId = rs.getString("studentid");
                double gpa1 = rs.getDouble("gpa1");
                double gpa2 = rs.getDouble("gpa2");
                double gpa3 = rs.getDouble("gpa3");
                StudentDTO dto = new StudentDTO(studentId, gpa1, gpa2, gpa3);
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
