package com.hans.backend.backend.appl.countries.resttemplate.service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.hans.backend.backend.appl.countries.resttemplate.config.CountryRestServiceConfig;
import com.hans.backend.backend.appl.countries.resttemplate.service.dto.RestCountry;
import com.hans.backend.backend.appl.countries.resttemplate.service.mappers.CountryRestMapper;
import com.hans.backend.backend.appl.countries.soap.service.dto.Country;
import com.hans.backend.backend.appl.countries.soap.service.mapper.impl.CountryMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class CountryRestService {

//    spring.security.oauth2.client.provider.keycloak.issuer-uri
    @Value( "${spring.security.oauth2.client.provider.keycloak.issuer-uri}" )
    private String keycloakIssuerUri;

    private final CountryRestMapper countryRestMapper;
    private final CountryRestServiceConfig countryRestServiceConfig;
    private final RestTemplate restTemplate;

    private String BASE_URL;

    public CountryRestService(CountryRestServiceConfig countryRestServiceConfig, CountryRestMapper countryRestMapper, CountryRestServiceConfig countryRestServiceConfig1, RestTemplate restTemplate) {
        this.countryRestMapper = countryRestMapper;

        this.countryRestServiceConfig = countryRestServiceConfig1;
        this.restTemplate = restTemplate;
        this.BASE_URL = STR."\{countryRestServiceConfig.getBaseurl().toString()}/\{countryRestServiceConfig.getVersion().toString()}";
    }


    public RestCountry getById(String id){
//        Optional<GameEntity> found = repository.findById(Long.parseLong(id));
//        if (found.isPresent()) {
//            MyPlayer player = restTemplate.getForObject("http://localhost:6060/api/players/200", MyPlayer.class);
//            System.out.println(player);
//            return mapper.toDTO(found.get());
//        }
//        return null;
//        RestCountry restCountry = restTemplate.getForObject(
//                countryRestServiceConfig.getBaseurl().toString()
//                        + "/" + countryRestServiceConfig.getVersion().toString() +
//                        "/" +  "/alpha/" + id,RestCountry.class);

        RestCountry restCountry = restTemplate.getForObject(
                countryRestServiceConfig.getBaseurl().toString()
                        + "/" + countryRestServiceConfig.getVersion().toString() +
                        "/" +  "/alpha/" + id + "?fields=capital,currencies,idd,flags",RestCountry.class);



        System.out.println(restCountry);

        return restCountry;


    }

//    public void getByIdLogger(String id){
//
////        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(STR."\{this.BASE_URL}/alpha/\{id}", Object[].class);
////        Object[] objects = responseEntity.getBody();
////        System.out.println(Arrays.toString(objects));
//
//
////        ResponseEntity<RestCountry[]> responseEntity = restTemplate.getForEntity(STR."\{this.BASE_URL}/alpha/\{id}",RestCountry[].class);
////        RestCountry[] objects = responseEntity.getBody();
////        System.out.println(Arrays.toString(objects));
//
//        // Extract capital from the response
//
////        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(BASE_URL + "/alpha/" + id, Object.class);
//        ResponseEntity<JsonNode[]> responseEntity = restTemplate.getForEntity(BASE_URL + "/alpha/" + id, JsonNode[].class);
//
//        Object responseObject = responseEntity.getBody();
//
//        // Extract response body
//        JsonNode[] countries = responseEntity.getBody();
//
//        // Check if response is not null and contains at least one country
//        if (countries != null && countries.length > 0) {
//            // Iterate over the countries array
//            for (JsonNode country : countries) {
//                // Get the capital node from the country node
//                JsonNode capitalNode = country.get("capital");
//
//                // Check if capital node exists and is not null
//                if (capitalNode != null && !capitalNode.isNull()) {
//                    // Check if capital node is an array and has at least one element
//                    if (capitalNode.isArray() && capitalNode.size() > 0) {
//                        // Get the first capital value from the array
//                        String capital = capitalNode.get(0).asText();
//                        // Process the capital value (e.g., print it)
//                        System.out.println("Capital: " + capital);
//                        // Break the loop since we found the capital
//                        break;
//                    }
//                }
//            }
//        } else {
//            System.out.println("No country data found.");
//        }
//    }

//    public String getCountryParameter(JsonNode country, String countryParam) {
//        JsonNode countryParamResultNode = country.get(countryParam);
//
//        if (countryParamResultNode != null && !countryParamResultNode.isNull()) {
//            if (countryParamResultNode.isArray() && !countryParamResultNode.isEmpty()) {
//                String result = countryParamResultNode.get(0).asText();
//                System.out.println(STR."\{countryParam} ; \{result}");
//                return result;
//            }
//        } else {
//            System.out.println(STR."No \{countryParam}data found.");
//            return null;
//        }
//        return null;
//    }


    public void getByIdLogger(String id){


        ResponseEntity<JsonNode[]> responseEntity2 = restTemplate.getForEntity(BASE_URL + "/alpha/" + id, JsonNode[].class);
        ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity(BASE_URL + "/alpha/" + id + "?fields=capital,currencies,idd,flags", JsonNode.class);
//        JsonNode responseObject = responseEntity.getBody();
        JsonNode countries = responseEntity.getBody();
        JsonNode[] countries2 = responseEntity2.getBody();

        if (countries != null) {
//            for (JsonNode country : countries) {

                // Capital
                Optional<String> capitalOptional = getCountryParameter2(countries, "capital");
                if (capitalOptional.isPresent()) {
                    String capital = capitalOptional.get();
                    System.out.println(STR."capital : \{capital}");
                }
                // Currency
                Optional<String> currenciesOptional = getCountryParameter2(countries, "currencies");
                if (currenciesOptional.isPresent()) {
                    String currencies = currenciesOptional.get();
                }
                // Phone
                String resultRoot = "";
                String resultSuffix = "";

                Optional<String> phoneIddRoot = getCountryParameter2(countries, "root");
                if (phoneIddRoot.isPresent()) {
                    resultRoot = phoneIddRoot.get();
                    System.out.println(STR."resultRoot : \{resultRoot}");
                }

                Optional<String> phoneIddSuffix = getCountryParameter2(countries, "suffixes");
                if (phoneIddSuffix.isPresent()) {
                    resultSuffix = phoneIddSuffix.get();
                    System.out.println(STR."Suffix : \{resultSuffix}");
                }
                String phoneIdd = resultRoot + resultSuffix;
                System.out.println("Phone Number : " + phoneIdd);
                // flagLocation (flags) png
                Optional<String> flagLocation = getCountryParameter2(countries, "png");
                if (flagLocation.isPresent()) {
                    String resultFlag = flagLocation.get();
                    System.out.println(STR."FlagLocation : \{resultFlag}");
                }
//            }
        }

//        if (countries2 != null) {
//            for (JsonNode country : countries2) {
//                // Capital
//                Optional<String> capitalOptional = getCountryParameter2(country, "capital");
//                if (capitalOptional.isPresent()) {
//                    String capital = capitalOptional.get();
//                    System.out.println(STR."capital : \{capital}");
//                }
//                // Currency
//                Optional<String> currenciesOptional = getCountryParameter2(country, "name");
//                if (currenciesOptional.isPresent()) {
//                    String currencies = currenciesOptional.get();
//                }
//                // Phone
//                String resultRoot = "";
//                String resultSuffix = "";
//
//                Optional<String> phoneIddRoot = getCountryParameter2(country, "root");
//                if (phoneIddRoot.isPresent()) {
//                    resultRoot = phoneIddRoot.get();
//                    System.out.println(STR."resultRoot : \{resultRoot}");
//                }
//
//                Optional<String> phoneIddSuffix = getCountryParameter2(country, "suffixes");
//                if (phoneIddSuffix.isPresent()) {
//                    resultSuffix = phoneIddSuffix.get();
//                    System.out.println(STR."Suffix : \{resultSuffix}");
//                }
//                String phoneIdd = resultRoot + resultSuffix;
//                System.out.println("Phone Number : " + phoneIdd);
//                // flagLocation (flags) png
//                Optional<String> flagLocation = getCountryParameter2(country, "png");
//                if (flagLocation.isPresent()) {
//                    String resultFlag = flagLocation.get();
//                    System.out.println(STR."FlagLocation : \{resultFlag}");
//                }
//            }
//        }



    }


//    public Optional<String> getCountryParameter(JsonNode country, String countryParam) {
//        JsonNode countryParamResultNode = country.get(countryParam);
//        System.out.println("countryParamResultNode != null : " + (countryParamResultNode != null));
//        System.out.println("!countryParamResultNode.isNull() : " + (!countryParamResultNode.isNull()));
//
//        if (countryParamResultNode != null && !countryParamResultNode.isNull()) {
//            System.out.println("countryParamResultNode.isArray() : " + (countryParamResultNode.isArray()));
//            System.out.println("countryParamResultNode Type : " + (countryParamResultNode.getNodeType()));
//            if (countryParamResultNode.isArray() && !countryParamResultNode.isEmpty()) {
//
//                String result = countryParamResultNode.get(0).asText();
//                System.out.println(countryParam + ": " + result);
//                return Optional.of(result);
//            }
//        } else {
//            System.out.println("No " + countryParam + " data found by getCountryParameter().");
//        }
//
//        return Optional.empty();
//    }

    public Optional<String> getCountryParameter(JsonNode country, String countryParam) {
        JsonNode countryParamResultNode = country.get(countryParam);
        if (countryParamResultNode != null && !countryParamResultNode.isNull()) {
            if (countryParamResultNode.isArray() && !countryParamResultNode.isEmpty()) {
                String result = countryParamResultNode.get(0).asText();
                System.out.println(countryParam + ": " + result);
                return Optional.of(result);
            } else if (countryParamResultNode.isObject()) {
                // Handle case where the parameter value is an object
                // Find the first key-value pair in the object and return the value
                printFields(countryParamResultNode);

                Iterator<Map.Entry<String, JsonNode>> fields = countryParamResultNode.fields();
                if (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    String value = entry.getValue().asText();
                    System.out.println(countryParam + ": " + value);
                    return Optional.of(value);
                }
            }
        } else {
            System.out.println("No " + countryParam + " data found by getCountryParameter().");
        }
        return Optional.empty();
    }

    public Optional<String> getCountryParameter2(JsonNode country, String countryParam) {
        JsonNode countryParamResultNode = country.get(countryParam);
        if (countryParamResultNode != null && !countryParamResultNode.isNull()) {

            Optional<String> result = getFields(countryParamResultNode);
            if (result.isPresent()) {
                return result;
            }

        }
        return Optional.empty();
    }


    public Optional<String> getFields(JsonNode countryParamResultNode) {

        if(countryParamResultNode.isArray()){
            ArrayNode arrayNode = (ArrayNode) countryParamResultNode;
            Iterator<JsonNode> elementsIterator = arrayNode.elements();
            while (elementsIterator.hasNext()) {
                JsonNode fieldName = elementsIterator.next();
                if (fieldName.isObject() || fieldName.isArray()) {
                    // If the element is an object or array, recursively process it
                    Optional<String> nestedResult = getFields(fieldName);
                    if (nestedResult.isPresent()) {
                        return nestedResult;
                    }
                } else {
                    // If the element is a simple value, return it
                    return Optional.of(fieldName.asText());
                }
            }
        } else if (countryParamResultNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fieldsIterator = countryParamResultNode.fields();

            while (fieldsIterator.hasNext()) {
                Map.Entry<String, JsonNode> field = fieldsIterator.next();
                String fieldName = field.getKey();
                JsonNode fieldValue = field.getValue();

                if (fieldValue.isObject() || fieldValue.isArray()) {
//                    System.out.println("Field: " + fieldName + " (Object/Array)");
                    getFields(fieldValue); // Recursively print fields of nested objects/arrays
                } else { // Assume string
//                    System.out.println("Field: " + fieldName + " - Value: " + fieldValue);
                    return  Optional.of(fieldName);
                }
            }
        }else{
            return Optional.of(countryParamResultNode.asText());
        }



        return Optional.empty();
    }



    // Een voorbeeldje van Recursion
    public void printFields(JsonNode countryParamResultNode) {
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = countryParamResultNode.fields();

        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            String fieldName = field.getKey();
            JsonNode fieldValue = field.getValue();

            if (fieldValue.isObject()) {
                System.out.println("Field: " + fieldName + " (Object)");
                printFields(fieldValue); // Recursively print fields of nested objects
            } else if (fieldValue.isArray()) {
                System.out.println("Field: " + fieldName + " (Array)");
                // Handle array elements if necessary
            } else {
                System.out.println("Field: " + fieldName + " - Value: " + fieldValue);
            }
        }
    }



        public void printUrl(){
        System.out.println("test een waarde van een config file");
        System.out.println("testje: " + keycloakIssuerUri);

        System.out.println("testje: " + countryRestServiceConfig.getBaseurl());
        System.out.println("testje: " + countryRestServiceConfig.getVersion());
    }


}
