package com.sathish.microservice.currencyexchangeservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("currency-exchange-service")
public class Configuration {

    private int test;


}
