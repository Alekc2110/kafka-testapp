package com.korsh.example.dataconsumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class DataConsumer2Application {

    public static void main(String[] args) {
        SpringApplication.run(DataConsumer2Application.class, args);
    }

}
