package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        String inputURL = "http://jax-rs-demo-test-project.192.168.99.100.nip.io/restservice/students";
//        Rest_Client restObject = new Rest_Client();
//        restObject.RestClient(inputURL);

        Scanner input = new Scanner(System.in);
        RestCaller restObject = new RestCaller();
        System.out.println("Put URL:");
        String inputURL = input.nextLine();
        restObject.RestCallerApp(inputURL);
    }
}
