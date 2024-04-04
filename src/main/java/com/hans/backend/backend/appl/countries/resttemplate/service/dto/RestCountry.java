package com.hans.backend.backend.appl.countries.resttemplate.service.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hans.backend.backend.base.base.service.dto.Base;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestCountry extends Base {


    private String capital;

    @JsonCreator
    public RestCountry(
            @JsonProperty("capital") String capital){
        this.capital = capital;
    }
//    private String currency;
//    private String flagB64;
//    private String flagB64Byte;
//    private String flagB64Byte2;
//    private String flagB64RAW;
//    private String flagLocation;
//    private String phonePrefix;


}