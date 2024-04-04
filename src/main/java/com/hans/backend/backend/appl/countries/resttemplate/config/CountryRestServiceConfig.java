package com.hans.backend.backend.appl.countries.resttemplate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("custom.com.restcountries.api")
@Component
@Data
public class CountryRestServiceConfig {
//    #https://restcountries.com/#api-endpoints-using-this-project
//    custom.com.restcountries.api.baseurl=https://restcountries.com
//    custom.com.restcountries.api.version=v3.1

    private String baseurl;
    private String version;

}
