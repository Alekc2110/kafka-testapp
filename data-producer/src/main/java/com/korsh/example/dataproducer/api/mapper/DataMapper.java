package com.korsh.example.dataproducer.api.mapper;

import com.korsh.example.dataproducer.api.dto.DataDto;
import com.korsh.example.dataproducer.domain.model.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto>{
}
