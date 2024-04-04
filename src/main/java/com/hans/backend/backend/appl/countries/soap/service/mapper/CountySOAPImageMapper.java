package com.hans.backend.backend.appl.countries.soap.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
@Mapper(componentModel = "spring")
public interface CountySOAPImageMapper {

    CountySOAPImageMapper INSTANCE = Mappers.getMapper(CountySOAPImageMapper.class);

    @Named("mapImageBytesToString")
    default String mapImageBytesToString(byte[] imageData) {
        if (imageData != null) {
            return Base64.getEncoder().encodeToString(imageData);
        }
        return null;
    }

    @Named("mapStringToImageBytes")
    default byte[] mapStringToImageBytes(String imageData) {
        if (imageData != null) {
            return Base64.getDecoder().decode(imageData);
        }
        return null;
    }
}
