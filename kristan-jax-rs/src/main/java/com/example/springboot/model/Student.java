package com.example.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Student {

    private String name = "";
    private String student_id = "";
    private String program = "";

    public Student(String name, String student_id, String program) {
        this.name = name;
        this.student_id = student_id;
        this.program = program;
    }
}
