package com.hans.backend.backend.appl.countries.soap.service.mapper.impl;

import com.hans.backend.backend.appl.countries.soap.service.dto.Country;
import com.hans.backend.backend.appl.countries.soap.service.mapper.ICountryMapper;
import com.hans.backend.backend.webservices.generated.CountryInfoService;
import com.hans.backend.backend.webservices.generated.CountryInfoServiceSoapType;
import org.mapstruct.Mapper;
import org.springframework.web.client.RestClient;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Mapper(componentModel = "spring")
public interface CountryMapper extends ICountryMapper {

//    @Override
//    public default Country mapCountryWStoCountry(String sCountryISOCode){
//        CountryInfoServiceSoapType soapService = new CountryInfoService().getCountryInfoServiceSoap();
//        Country country = new Country();
//        country.setCapital(soapService.capitalCity(sCountryISOCode));
//        country.setCurrency(soapService.currencyName(sCountryISOCode));
//        country.setPhonePrefix(soapService.countryIntPhoneCode(sCountryISOCode));
//        country.setFlagLocation(soapService.countryFlag(sCountryISOCode));
//        return country;
//    }

    @Override
    public default Country mapCountryWStoCountry(String sCountryISOCode) throws UnsupportedEncodingException {

        CountryInfoServiceSoapType soapService = new CountryInfoService().getCountryInfoServiceSoap12();
        Country country = new Country();
        country.setFullName(soapService.countryName(sCountryISOCode));
        country.setCapital(soapService.capitalCity(sCountryISOCode));
        country.setCurrency(soapService.countryCurrency(sCountryISOCode).getSName());
        country.setPhonePrefix(soapService.countryIntPhoneCode(sCountryISOCode));
        country.setFlagLocation(soapService.countryFlag(sCountryISOCode));
        RestClient restClient = RestClient.create();
        String countryB4result = restClient.get().uri(country.getFlagLocation()).retrieve().body(String.class);
//        String countryB4resultRAW = restClient.get().uri(country.getFlagLocation()).accept(MediaType.IMAGE_JPEG).retrieve().body(String.class);
        String countryB4resultRAW = restClient.get().uri(country.getFlagLocation()).retrieve().body(String.class);
        byte[] countryB4resultRAW2 = restClient.get().uri(country.getFlagLocation()).retrieve().body(byte[].class);


        if(countryB4resultRAW2 != null){
//            byte[] flagData = countryB4resultRAW.getBytes(StandardCharsets.UTF_8);
            String base64FaceData = Base64.getEncoder().encodeToString(countryB4resultRAW2);
            country.setFlagB64(base64FaceData);
        }


        return country;

    }



//        CountryInfoServiceSoapType soapService = new CountryInfoService().getCountryInfoServiceSoap();
//        Country country = new Country();
//        country.setCapital(soapService.capitalCity(sCountryISOCode));
//        country.setCurrency(soapService.currencyName(sCountryISOCode));
//        country.setPhonePrefix(soapService.countryIntPhoneCode(sCountryISOCode));
//        country.setFlagLocation(soapService.countryFlag(sCountryISOCode));
//        return country;

}
