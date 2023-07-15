package com.example.knopka_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@SpringBootApplication
public class KnopkaV2Application {

    public static void main(String[] args) {
        SpringApplication.run(KnopkaV2Application.class, args);
    }

}
