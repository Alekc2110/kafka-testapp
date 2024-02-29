package com.korsh.example.dataconsumer1.config;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class BeanConfig {

    @SneakyThrows
    @Bean
    public XML consumerXML(){
        return new XMLDocument(
                new File("C:/Users/korsu/IdeaProjects/message-broker-app/data-consumer1/src/main/resources/kafka/consumer.xml"));
    }

}
