package com.kristan.jaxrsdemo.service;

import javax.ws.rs.core.Response;

import com.kristan.jaxrsdemo.model.Student;
import com.kristan.jaxrsdemo.repository.StudentRepository;
import com.kristan.jaxrsdemo.exception.StudentNotFoundException;

import java.util.Collection;


public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Response getById(Long id) {
        Student student = repository.findById(id).orElseThrow(StudentNotFoundException::new);
        return Response.ok(student).build();
    }

}
