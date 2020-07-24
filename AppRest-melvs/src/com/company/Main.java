package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//      String inputURL = "http://localhost:8080";
        RestCaller restObject = new RestCaller();
        restObject.RestCallerApp();

//        Scanner input = new Scanner(System.in);
//        RestCaller restObject = new RestCaller();
//        System.out.println("Put URL:");
//        String inputURL = input.nextLine();
//        restObject.RestCallerApp(inputURL);
    }
}
