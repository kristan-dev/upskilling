package com.example.springboot;

import com.example.springboot.model.Student;
import com.example.springboot.repository.StudentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;

public class StudentRepositoryTest {

    @Test
    void getAllStudentsTest() {
        HashMap<String, Student> studentCount = new HashMap<>();
        StudentRepository initRepo = new StudentRepository();
        Collection<Student> students = initRepo.getAllStudents();
        Assert.assertEquals(3, students.size());
    }
}
