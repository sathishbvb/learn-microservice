package com.sathish.microservice.currencyconversionservice.datamodels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrencyConversion {

    private Long id;
    private String from;
    private String to;
    private float conversionMultiple;
    private float quantity;
    private float totalCalculationAmount;
    private String environment;
}
