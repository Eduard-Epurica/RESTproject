package com.eduard.RESTCourse.rest;

import com.eduard.RESTCourse.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    // define @PostrConstruct ot load the student data ...only once!

    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();
        this.studentList.add(new Student("Eduard","Epurica"));
        this.studentList.add(new Student("Ana","Safta"));
        this.studentList.add(new Student("Vlad","Manole"));
        this.studentList.add(new Student("Claudiu","Epurica"));
    }
    //define endpoint for /students - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return studentList;

    }

    //define endpoint for /students/{studentID} - return student at index
    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {

        return studentList.get(studentID);

    }

}
