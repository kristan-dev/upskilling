package com.example.springboot.repository;

import com.example.springboot.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Students {

    Map<String, Student> students = new HashMap<>();

    private void populateStudents() {
        students.put("student1", new Student("Kristan", "0", "BSCS"));
        students.put("student2",new Student("Melvin", "1", "BSCS"));
        students.put("student3",new Student("Joseph", "2", "MSCS"));
    }

    public Collection<Student> getAllStudents() {
        populateStudents();
        return this.students.values();
    }
}
