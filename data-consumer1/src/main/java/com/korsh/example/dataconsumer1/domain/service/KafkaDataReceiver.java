package com.korsh.example.dataconsumer1.domain.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.korsh.example.dataconsumer1.config.LocalDateTimeDeserializer;
import com.korsh.example.dataconsumer1.domain.model.Data;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaDataReceiver {
    private final KafkaReceiver<String,Object> receiver;
    private final LocalDateTimeDeserializer deserializer;
    private final KafkaDataService service;

    @PostConstruct
    private void init(){
        fetch();
    }

    public void fetch(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        deserializer)
                .create();
     receiver.receive()
             .subscribe(receiverRecord -> {
                 Data data = gson.fromJson(receiverRecord.value().toString(), Data.class);
                 service.handle(data);
                 receiverRecord.receiverOffset().acknowledge();
             });
    }
}
