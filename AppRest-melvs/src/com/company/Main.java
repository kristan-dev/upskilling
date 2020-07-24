package com.company;

public class Main {

    public static void main(String[] args) throws  Exception{

                System.out.println("Your URL" +args[0]);
                RestCaller restObject = new RestCaller();
                String response = restObject.RestCallerApp(args[0]);
                System.out.println(response);
    }
}
