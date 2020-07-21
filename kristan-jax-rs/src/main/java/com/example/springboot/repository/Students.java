package com.example.springboot.repository;

import com.example.springboot.model.Student;

import java.util.HashMap;
import java.util.LinkedList;

import org.json.JSONObject;

public class Students {

    private LinkedList<Student> populateStudents() {
        LinkedList<Student> students = new LinkedList<>();
        Student student1 = new Student("Kristan", "0", "BSBC");
        Student student2 = new Student("Melvin", "1", "BSIT");
        Student student3 = new Student("Joseph", "2", "MSCS");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }

    public LinkedList<String> getAllStudents() {
        LinkedList<Student> students = this.populateStudents();
        LinkedList<HashMap> studentsAsMap= this.mappedStudents(students);

        return this.convertMapToJson(studentsAsMap);
    }

    private LinkedList<HashMap> mappedStudents(LinkedList<Student> students) {

        LinkedList<HashMap> allStudents = new LinkedList<>();

        for (Student student : students) {
            HashMap<String, String> studentMap = new HashMap<>();
            studentMap.put("Name", student.getName());
            studentMap.put("ID", student.getStudent_id());
            studentMap.put("Course", student.getProgram());
            allStudents.add(studentMap);
        }
        return allStudents;
    }

    private LinkedList<String> convertMapToJson(LinkedList<HashMap> studentsAsMap) {
        LinkedList<String> studentsAsJsonString = new LinkedList<>();

        for (HashMap<String, String> student: studentsAsMap) {
            JSONObject jsonStudent = new JSONObject(student);
            studentsAsJsonString.add(jsonStudent.toString());
        }

        return studentsAsJsonString;
    }

}
