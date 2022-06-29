package com.example.studentbackend.service;

import java.util.ArrayList;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student role=studentRepository.findByName(username);
        if(role==null) {
            throw new UsernameNotFoundException("No user with name: "+username);
        }
        //System.out.println(role);
        return role;

    }
}