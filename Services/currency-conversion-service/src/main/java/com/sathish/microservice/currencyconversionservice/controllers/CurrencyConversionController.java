package com.sathish.microservice.currencyconversionservice.controllers;

import com.sathish.microservice.currencyconversionservice.datamodels.CurrencyConversion;
import com.sathish.microservice.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeProxy proxy;

    //    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversion convertCurrencyVal(@PathVariable String from, @PathVariable String to, @PathVariable float quantity) {
//        String port = environment.getProperty("local.server.port");
//        float usdTOInrRate = 80.00f;
//        float convertedVal = quantity * usdTOInrRate;
//        return new CurrencyConversion(1000l, from, to, usdTOInrRate, quantity, convertedVal, port);
//    }
    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrencyVal(@PathVariable String from, @PathVariable String to, @PathVariable float quantity) {
        String port = environment.getProperty("local.server.port");
        CurrencyConversion currencyConversion = proxy.getCurrencyExchange(from, to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculationAmount(currencyConversion.getConversionMultiple()*currencyConversion.getQuantity());
        currencyConversion.setEnvironment(port+" "+"feign");
        return currencyConversion;
    }
}
