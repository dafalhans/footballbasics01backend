package com.hans.backend.backend.appl.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface ImageMapper {

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
