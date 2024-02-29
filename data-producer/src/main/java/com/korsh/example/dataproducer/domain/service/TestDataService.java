package com.korsh.example.dataproducer.domain.service;

import com.korsh.example.dataproducer.domain.model.Data;
import com.korsh.example.dataproducer.domain.model.MeasurementType;
import com.korsh.example.dataproducer.domain.model.test.DataTestOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataService {

    private final ScheduledExecutorService executorService =
            Executors.newSingleThreadScheduledExecutor();
    private final KafkaDataService service;
    public void sendMessages(DataTestOptions testOptions) {
        if(testOptions.getMeasurementTypes().length > 0){
            executorService.scheduleAtFixedRate(
                    ()-> {
                        Data data = new Data();
                        data.setSensorId(new Random().nextLong(1,11));
                        data.setMeasurement(new Random().nextDouble(15, 101));
                        data.setMeasurementType(
                                MeasurementType.values()
                                        [new Random().nextInt(0, MeasurementType.values().length)]
                        );
                        data.setTimestamp(LocalDateTime.now());
                        service.send(data);
                    },
                    0,
                    testOptions.getDelayInSeconds(),
                    TimeUnit.SECONDS
            );
        }
    }
}
