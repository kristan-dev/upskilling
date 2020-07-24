package com.company;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RestCaller {

    public String RestCallerApp() {

        String hello = "https://reqres.in/api/users?page=2";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(hello))
                .timeout(Duration.ofSeconds(5))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> { System.out.println("Status Code: " + response.statusCode());
                  return response; } )
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        String s = request.method();
        return s;
    }
}
