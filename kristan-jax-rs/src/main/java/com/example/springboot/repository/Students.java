package com.example.springboot.repository;

import com.example.springboot.model.Student;

import java.util.HashMap;
import java.util.LinkedList;

import org.json.JSONObject;

public class Students {

    private LinkedList<Student> populateStudents() {
        LinkedList<Student> students = new LinkedList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();

        student1.setStudentName("Kristan");
        student1.setStudent_id("0");
        student1.setProgram("BSCS");
        students.add(student1);

        student2.setStudentName("Melvin");
        student2.setStudent_id("1");
        student2.setProgram("BSIT");
        students.add(student2);

        student3.setStudentName("Joseph");
        student3.setStudent_id("2");
        student3.setProgram("MSCS");
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
            studentMap.put("Name", student.getStudentName());
            studentMap.put("ID", student.getStudent_Id());
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
