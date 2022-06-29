package com.example.studentbackend.controller;

import com.example.studentbackend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.studentbackend.repository.StudentRepository;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
//@RequestMapping("/api/v1/students")
//@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //saving students
    @PostMapping(value = "api/v1/students")
    public Student createStudent(@RequestBody Student student){
        student.setPass((new BCryptPasswordEncoder()).encode(student.getPass()));
        return studentRepository.save(student);
    }

    @RequestMapping(value= "api/v1/students", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUser() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }


}
