package com.example.springboot;
import com.example.springboot.repository.Students;
import com.example.springboot.repository.Programs;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;


public class RepositoryTest {

    @Test
    void getAllProgramsTest() {
        Programs initRepo = new Programs();
        Assert.isTrue(initRepo.getAllPrograms().size() == 3, "Programs Repo Test");
    }

    @Test
    void getAllStudentsTest() {
        Students initRepo = new Students();
        Assert.isTrue(initRepo.getAllStudents().size() == 3, "Students Repo Test");
    }
}
