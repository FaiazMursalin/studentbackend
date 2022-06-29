package com.example.studentbackend;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.repository.StudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentRepoTest {

    @Before
    public void setup()
    {
        System.out.println("....Unit Test Started....");
    }

    @MockBean
    private StudentRepository studentRepository;

    @Test
    public void testRetrieveStudentWithMockRepository1() throws Exception {

        Optional<Student> optStudent = Optional.of( new Student("jewel","Dhaka",11504,26,"STUDENT","$2a$12$AvS3dSnFiBagwDPwN1h8PeivsKkAljoVU3EsiduHyxBTisrPsSsKy"));
        when(studentRepository.findById(1L)).thenReturn(optStudent);

        assertTrue(studentRepository.findById(1L).get().getName().contains("jewel"));
    }

    @Test
    public void testRetrieveStudentWithMockRepository2() throws Exception {

        Optional<Student> optStudent = Optional.of( new Student("jewel","Dhaka",11504,26,"STUDENT","$2a$12$AvS3dSnFiBagwDPwN1h8PeivsKkAljoVU3EsiduHyxBTisrPsSsKy"));
        when(studentRepository.findById(1L)).thenReturn(optStudent);

        assertTrue(studentRepository.findById(1L).get().getName().contains("arka"));
    }


    @After
    public void tearDown()
    {
        System.out.println("....Unit Test Ended....");
    }

}
