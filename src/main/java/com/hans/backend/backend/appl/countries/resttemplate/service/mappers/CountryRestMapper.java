package com.hans.backend.backend.appl.countries.resttemplate.service.mappers;

import com.hans.backend.backend.appl.countries.soap.service.dto.Country;
import com.hans.backend.backend.appl.countries.soap.service.mapper.ICountryMapper;
import org.mapstruct.Mapper;

import java.io.UnsupportedEncodingException;

@Mapper(componentModel = "spring")
public class CountryRestMapper implements ICountryMapper {

    @Override
    public Country mapCountryWStoCountry(String scountryISOCode) throws UnsupportedEncodingException {
        return null;
    }
}
