package com.hans.backend.backend.sec.configuration;


import com.hans.backend.backend.sec.security.DemoJwtConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    /*
    Need : spring.security.oauth2.resourceserver.jwt.issuer-uri in application.properties
    Check : https://www.youtube.com/watch?v=DLszg2ul85U
     */
    /*
    Need : spring.security.oauth2.resourceserver.jwt.issuer-uri in application.properties
       */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .oauth2Login(withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(demoConvertor())));
        return http.build();
    }







//    @Bean
//    @Order(100)
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////    SecurityFilterChain securityFilterChain(HttpSecurity http, ClientRegistrationRepository clientRegistrationRepository) throws Exception {
//
////        String base_uri = OAuth2AuthorizationRequestRedirectFilter.DEFAULT_AUTHORIZATION_REQUEST_BASE_URI;
////        DefaultOAuth2AuthorizationRequestResolver resolver = new DefaultOAuth2AuthorizationRequestResolver(clientRegistrationRepository, base_uri);
////
////        // Responsible for enabling PKCE, to generate code verifier, code challenge
////        resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
//
//
//        http.cors(withDefaults())
//                .authorizeHttpRequests(auth ->
//                    auth.requestMatchers("/login","index.html", "*.ico", "*.css", "*.js").permitAll()
//                    .anyRequest().authenticated())
////                .oauth2Login(
////                        oauth2Login -> {oauth2Login.authorizationEndpoint(authorizationEndpointConfig -> authorizationEndpointConfig.authorizationRequestResolver(resolver));
////                            oauth2Login.tokenEndpoint(tokenEndpointConfig -> tokenEndpointConfig.accessTokenResponseClient(authorizationCodeTokenResponseClient()));
////                })
//                .oauth2Login(
//                        oauth2Login -> {oauth2Login.tokenEndpoint(tokenEndpointConfig -> tokenEndpointConfig.accessTokenResponseClient(authorizationCodeTokenResponseClient()));
//
//                        })
//
////                        auth.anyRequest().authenticated())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(demoConvertor())));
//        return http.build();
//    }

//    @Bean
//    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> authorizationCodeTokenResponseClient() {
//
////        System.out.println("kom ik hier?");
//
//        OAuth2AccessTokenResponseHttpMessageConverter tokenResponseHttpMessageConverter =
//                new OAuth2AccessTokenResponseHttpMessageConverter();
////
////        DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient =
////                new DefaultAuthorizationCodeTokenResponseClient();
////        accessTokenResponseClient.setRequestEntityConverter(new CustomRequestEntityConverter());
//
////        tokenResponseHttpMessageConverter.setAccessTokenResponseConverter(new CustomAccessTokenResponseConverter());
//        tokenResponseHttpMessageConverter.setAccessTokenResponseConverter((Converter) new CustomAccessTokenResponseConverter());
//
////        System.out.println(STR."debug: tokenResponseHttpMessageConverter :\{tokenResponseHttpMessageConverter}");
//
////        tokenResponseHttpMessageConverter.setTokenResponseConverter(new CustomAccessTokenResponseConverter());
//
//        RestTemplate restTemplate = new RestTemplate(Arrays.asList(
//                new FormHttpMessageConverter(), tokenResponseHttpMessageConverter));
//
//        restTemplate.setErrorHandler(new OAuth2ErrorResponseErrorHandler());
//
//        DefaultAuthorizationCodeTokenResponseClient tokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
//        tokenResponseClient.setRestOperations(restTemplate);
//
//        return tokenResponseClient;
//    }

//    private Customizer<OAuth2LoginConfigurer<HttpSecurity>> hansTest() {
//
//    }


//    @Bean
//    @Order(101)
//    SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
//        http.cors(Customizer.withDefaults())
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/actuator").permitAll()
//                                .anyRequest().authenticated())
//                .oauth2Login(withDefaults())
////                        auth.anyRequest().authenticated())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(demoConvertor())));
//        return http.build();
//    }


    private Converter<Jwt,? extends AbstractAuthenticationToken> demoConvertor() {
        System.out.println("debug van demoConvertor");
        return new DemoJwtConverter();
    }
}

