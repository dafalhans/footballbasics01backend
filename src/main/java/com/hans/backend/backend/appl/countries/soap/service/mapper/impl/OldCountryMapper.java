package com.hans.backend.backend.appl.countries.soap.service.mapper.impl;


import com.hans.backend.backend.appl.countries.soap.repository.CountryEntity;
import com.hans.backend.backend.appl.countries.soap.service.dto.Country;
import com.hans.backend.backend.base.base.service.mapper.IMapper;
import com.hans.backend.backend.webservices.generated.CountryInfoService;
import com.hans.backend.backend.webservices.generated.CountryInfoServiceSoapType;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
//public interface CountryMapper extends IMapper<CountryEntity, Country> {
public interface OldCountryMapper extends IMapper<CountryEntity, Country> {
    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
    @Override
    CountryEntity toEntity(Country dto);

    //   @Mapping(source = "creationDate", target = "creationDate", ignore = true)
    //   @Mapping(source = "modificationDate", target = "modificationDate", ignore = true)
    @Mapping(source = "creationDate", target = "creationDate")
    @Mapping(source = "modificationDate", target = "modificationDate")
    @Override
    Country toDTO(CountryEntity entity);


//    private String capital;
//    private String currency;
//    private String flagB64;
//    private String flagLocation;
//    private String phonePrefix;



    @AfterMapping()
    default void countryToCountryWSDetails(@MappingTarget Country country,String sCountryISOCode){
        CountryInfoServiceSoapType soapService = new CountryInfoService().getCountryInfoServiceSoap();
        country.setCapital(soapService.capitalCity(sCountryISOCode));
        country.setCurrency(soapService.currencyName(sCountryISOCode));
        country.setPhonePrefix(soapService.countryIntPhoneCode(sCountryISOCode));
        country.setFlagLocation(soapService.countryFlag(sCountryISOCode));
    }

}