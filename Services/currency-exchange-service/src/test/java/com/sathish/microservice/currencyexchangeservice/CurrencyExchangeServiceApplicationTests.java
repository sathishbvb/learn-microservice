package com.sathish.microservice.currencyexchangeservice;

import com.sathish.microservice.currencyexchangeservice.configuration.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyExchangeServiceApplicationTests {

	@Autowired
	Configuration configuration;
	@Test
	void contextLoads() {
		assert configuration.getTest()==30;
	}

}
