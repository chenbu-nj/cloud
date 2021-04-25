package com.example.clientb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientbApplication.class, args);
    }
}
