package com.korsh.example.dataproducer.api.controller;

import com.korsh.example.dataproducer.api.dto.DataDto;
import com.korsh.example.dataproducer.api.dto.DataTestOptionsDto;
import com.korsh.example.dataproducer.api.mapper.DataMapper;
import com.korsh.example.dataproducer.api.mapper.DataTestOptionsMapper;
import com.korsh.example.dataproducer.domain.model.Data;
import com.korsh.example.dataproducer.domain.model.test.DataTestOptions;
import com.korsh.example.dataproducer.domain.service.KafkaDataService;
import com.korsh.example.dataproducer.domain.service.TestDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/data")
@RequiredArgsConstructor
public class DataController {
    private final KafkaDataService service;
    private final DataMapper mapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;
    private final TestDataService testDataService;


    @PostMapping
    public void send(@RequestBody DataDto dto){
        Data data = mapper.toEntity(dto);
        service.send(data);
    }

    @PostMapping("/test")
    public void testSend(@RequestBody DataTestOptionsDto dto){
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(dto);
        testDataService.sendMessages(testOptions);
    }
}
