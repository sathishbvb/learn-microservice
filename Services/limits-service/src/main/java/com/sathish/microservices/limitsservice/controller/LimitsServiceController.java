package com.sathish.microservices.limitsservice.controller;


import com.sathish.microservices.limitsservice.configuration.Configuration;
import com.sathish.microservices.limitsservice.service.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsServiceController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
