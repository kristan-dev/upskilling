package com.example.springboot.model;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class StudentBuilder {
    private final String id;
    private final String name;
    private final String program;
}
