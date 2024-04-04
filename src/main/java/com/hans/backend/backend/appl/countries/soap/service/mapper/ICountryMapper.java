package com.hans.backend.backend.appl.countries.soap.service.mapper;


import com.hans.backend.backend.appl.countries.soap.service.dto.Country;
import org.mapstruct.Mapper;

import java.io.UnsupportedEncodingException;

@Mapper(componentModel = "spring")
public interface ICountryMapper {
    Country mapCountryWStoCountry(String scountryISOCode) throws UnsupportedEncodingException;
}
