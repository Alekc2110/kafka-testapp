package com.korsh.example.dataproducer.api.dto;

import com.korsh.example.dataproducer.domain.model.MeasurementType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptionsDto {
    private int delayInSeconds;
    private MeasurementType[] measurementTypes;
}
