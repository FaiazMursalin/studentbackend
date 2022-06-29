package com.example.studentbackend.model;

import com.example.studentbackend.view.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@EnableAutoConfiguration
@Table(name = "studentInfo")
public class Student implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    @JsonView(View.Student.class)
    private String name;
    @Column(name = "address")
    @JsonView(View.Student.class)
    private String address;
    @Column(name = "student_id")
    @JsonView(View.Student.class)
    private int student_id;
    @Column(name = "age")
    @JsonView(View.Admin.class)
    private int age;

    @Column(name="role")
    @JsonView(View.Admin.class)
    private String role;

    @Column(name="pass")
    @JsonView(View.Admin.class)
    private String pass;

    public Student(){

    }

    public Student(String name, String address, int student_id, int age, String role, String pass) {
        this.name = name;
        this.address = address;
        this.student_id = student_id;
        this.age = age;
        this.role = role;
        this.pass = pass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));//singleton design pattern
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.pass;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

