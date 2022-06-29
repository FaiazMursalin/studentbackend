package com.example.studentbackend;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentbackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentbackendApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Student student1= new Student();
//        student1.setName("faiaz");
//        student1.setStudent_id(18105);
//        student1.setAddress("dhaka");
//        student1.setAge(24);
//        student1.setRole("STUDENTS");
//        student1.setPassword("faiaz");
//        studentRepository.save(student1);
//
//        Student student2= new Student();
//        student2.setName("faiaz");
//        student2.setStudent_id(18105);
//        student2.setAddress("dhaka");
//        student2.setAge(24);
//        student2.setRole("STUDENTS");
//        student2.setPassword("faiaz");
//        studentRepository.save(student2);

    }
}
