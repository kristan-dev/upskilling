package com.example.springboot.model;

import lombok.Data;

@Data
// A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, 
// and @Setter on all non-final fields, and @RequiredArgsConstructor!
public class Student {

    private final String name;
    private final String student_id;
    private final String program;

    public Student(String name, String student_id, String program) {
        this.name = name;
        this.student_id = student_id;
        this.program = program;
    }
}
