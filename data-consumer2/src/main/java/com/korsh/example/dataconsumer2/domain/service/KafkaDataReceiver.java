package com.korsh.example.dataconsumer2.domain.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.korsh.example.dataconsumer2.config.LocalDateTimeDeserializer;
import com.korsh.example.dataconsumer2.domain.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class KafkaDataReceiver {

    private final LocalDateTimeDeserializer deserializer;
    private final KafkaDataService service;

    public KafkaDataReceiver(LocalDateTimeDeserializer deserializer, KafkaDataService service) {
        this.deserializer = deserializer;
        this.service = service;
    }

    @KafkaListener(topics = "data-temperature")
    @KafkaListener(topics = "data-power")
    @KafkaListener(topics = "data-voltage")
    public void fetchTopicsMessages(ConsumerRecord<String, Object> record, Acknowledgment ack) {
        log.info("!record partitions: {}, record topic: {}", record.partition(), record.topic());
        log.info("!record key: {}, record value: {}", record.key(), record.value());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        deserializer)
                .create();
        Data data = gson.fromJson(record.value().toString(), Data.class);
        service.handle(data);
        ack.acknowledge();
    }
}
