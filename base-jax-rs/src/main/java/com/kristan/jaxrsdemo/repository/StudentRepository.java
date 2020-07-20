package com.kristan.jaxrsdemo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.kristan.jaxrsdemo.model.Student;

@Repository
public class StudentRepository {
    Map<Long, Student> students = new HashMap<>();

    @PostConstruct
    public void init() {
        students.put(101l, new Student(101l, "Kristan", "Sangalang", "Junior"));
        students.put(102l, new Student(102l, "Joseph", "Garcia", "Senior"));
        students.put(103l, new Student(103l, "Melvin", "Bana-ag", "Freshman"));
    }

    public Collection<Student> findAll() {
        return students.values();
    }

    public Optional<Student> findById(Long id){
        Student student = null;
        if (students.containsKey(id)) student = students.get(id);
        return Optional.ofNullable(student);
    }
}
