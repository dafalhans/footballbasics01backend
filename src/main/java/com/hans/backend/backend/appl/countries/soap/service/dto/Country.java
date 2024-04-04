package com.hans.backend.backend.appl.countries.soap.service.dto;


import com.hans.backend.backend.base.base.service.dto.Base;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Country extends Base {


    private String capital;
    private String currency;
    private String flagB64;
    private String flagB64Byte;
    private String flagB64Byte2;
    private String flagB64RAW;
    private String flagLocation;
    private String phonePrefix;
    private String fullName;


}