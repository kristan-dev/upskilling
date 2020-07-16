package com.example.springboot.model;

public class Student {

    private String name = "";
    private String student_id = "";
    private String program = "";

    public String getStudentName() {
        return this.name;
    }
    public void setStudentName(String name) {
        this.name = name;
    }
    public String getStudent_Id() {
        return this.student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public String getProgram() {
        return this.program;
    }
    public void setProgram (String program) {
        this.program = program;
    }
}
