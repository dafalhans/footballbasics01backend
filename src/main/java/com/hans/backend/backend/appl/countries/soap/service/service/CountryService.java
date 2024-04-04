package com.hans.backend.backend.appl.countries.soap.service.service;


import com.hans.backend.backend.appl.countries.soap.repository.CountryRepository;
import com.hans.backend.backend.appl.countries.soap.service.dto.Country;
import com.hans.backend.backend.appl.countries.soap.service.mapper.impl.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository repository;
    private final CountryMapper countryMapper;


    public Country getById(String id) throws UnsupportedEncodingException {
        return countryMapper.mapCountryWStoCountry(id);
    }




}