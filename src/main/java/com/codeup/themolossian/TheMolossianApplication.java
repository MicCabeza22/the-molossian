package com.codeup.themolossian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class TheMolossianApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(TheMolossianApplication.class, args);
//    }
    public static void main(String[] args) {
        SpringApplication.run(TheMolossianApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TheMolossianApplication.class);
    }
}
