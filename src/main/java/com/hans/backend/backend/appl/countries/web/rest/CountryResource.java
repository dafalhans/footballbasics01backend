package com.hans.backend.backend.appl.countries.web.rest;


import com.hans.backend.backend.appl.countries.soap.service.dto.Country;
import com.hans.backend.backend.appl.countries.soap.service.service.CountryService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CountryResource {

    private final Logger logger = LoggerFactory.getLogger(CountryResource.class);

    private final CountryService service;

    @GetMapping("/countries/health")
    public ResponseEntity<String> up() {
        return ResponseEntity.ok("Country Resource up and running");
    }

//    @GetMapping("/countries")
//    public ResponseEntity<List<Country>> getAll() {
//        logger.debug("Get all countries ");
//        List<Country> dtos = service.getAll();
//        return ResponseEntity.ok(dtos);
//    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getById(@PathVariable String id) throws UnsupportedEncodingException {
        logger.debug("Get Country by id: {}", id);
        Country dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }



}