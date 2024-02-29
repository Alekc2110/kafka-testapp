package com.korsh.example.dataproducer.api.mapper;

import com.korsh.example.dataproducer.api.dto.DataTestOptionsDto;
import com.korsh.example.dataproducer.domain.model.Data;
import com.korsh.example.dataproducer.domain.model.test.DataTestOptions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto>{
}
