package com.dsq.web;

import com.dsq.entity.Student;
import com.dsq.entity.UserEntity;
import com.dsq.mapper.StudentMapper;
import com.dsq.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 2018/12/13.
 */
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;


    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        Student user=studentMapper.getStudent(id);
        return user;
    }

    @RequestMapping("/students")
    public  List<Student> students() {
        List<Student> students=studentMapper.getAllStudent();
        return students;
    }

    @RequestMapping("/student/add")
    public  List<Student> addStudent(Student student) {
        studentMapper.addStudent(student);
        List<Student> students=studentMapper.getAllStudent();
        return students;
    }

    @RequestMapping("/student/delete/{id}")
    public  List<Student> deleteStudent(@PathVariable int id) {
        studentMapper.deleteStudent(id);
        List<Student> students=studentMapper.getAllStudent();
        return students;
    }

    @RequestMapping("/student/update")
    public  List<Student> updateStudent(Student student) {
        studentMapper.updateStudent(student);
        List<Student> students=studentMapper.getAllStudent();
        return students;
    }
}
