package com.anhvv.hibernate.example;

import com.anhvv.hibernate.example.batch.BatchController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateExampleApplication {

    @Autowired
    private BatchController batchController;

    public static void main(String[] args) {
        SpringApplication.run(HibernateExampleApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            batchController.createBatchSchool();
        };
    }
}
