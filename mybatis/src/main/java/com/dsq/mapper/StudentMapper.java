package com.dsq.mapper;

import com.dsq.entity.Student;

import java.util.List;

/**
 * Created by aa on 2019/7/24.
 */
public interface StudentMapper {

    Student getStudent(int id);

    List<Student> getAllStudent();

    void addStudent(Student student);


    void deleteStudent(int id);

    void updateStudent(Student student);
}
