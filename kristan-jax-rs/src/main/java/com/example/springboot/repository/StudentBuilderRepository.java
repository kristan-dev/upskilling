package com.example.springboot.repository;

import com.example.springboot.model.StudentBuilder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentBuilderRepository {
    Map<String, StudentBuilder> studentBuilds = new HashMap<>();

    private void populateStudents() {
        StudentBuilder student0 = StudentBuilder.builder()
                .id("000")
                .program("BSCS")
                .name("Kristan")
                .build();

        StudentBuilder student1 = StudentBuilder.builder()
                .id("001")
                .program("BSIT")
                .name("Melvin")
                .build();

        StudentBuilder student2 = StudentBuilder.builder()
                .id("002")
                .program("MSCS")
                .name("Joseph")
                .build();

        studentBuilds.put("studentData0", student0);
        studentBuilds.put("studentData1", student1);
        studentBuilds.put("studentData2", student2);
    }

    public String getAllStudents() {
        return this.studentBuilds.values().toString();
    }
}
