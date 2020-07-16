package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springboot.model.Student;
import com.example.springboot.view.Students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

@SpringBootApplication
public class Application {

//	@Bean
//	public ArrayList<Student> initStudentList() {
//		Students studentInfo = new Students();
//		return studentInfo.getAllStudents();
//	}

	@Bean
	public LinkedList<String> initStudents() {
		Students studentInfo = new Students();
		return studentInfo.getAllStudents();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}