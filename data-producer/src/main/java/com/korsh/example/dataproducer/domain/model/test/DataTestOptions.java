package com.korsh.example.dataproducer.domain.model.test;

import com.korsh.example.dataproducer.domain.model.MeasurementType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptions {
    private int delayInSeconds;
    private MeasurementType[] measurementTypes;
}
