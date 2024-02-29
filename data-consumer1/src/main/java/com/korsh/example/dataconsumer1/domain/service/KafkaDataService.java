package com.korsh.example.dataconsumer1.domain.service;

import com.korsh.example.dataconsumer1.domain.model.Data;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataService {

    public void handle(Data data){
        System.out.println("Data object received: " + data.toString());
    }
}
