package com.example.springboot.repository;

import com.example.springboot.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

public class StudentRepository {

  Map<String, Student> students = new HashMap<>();

  @PostConstruct
  public void populateStudents() {
    students.put("studentData0", new Student("Kristan", "000", "BSCS"));
    students.put("studentData1", new Student("Melvin", "001", "BSIT"));
    students.put("studentData2", new Student("Joseph", "002", "MSCS"));
  }

  public Collection<Student> getAllStudents() {
    populateStudents();
    return students.values();
  }
}