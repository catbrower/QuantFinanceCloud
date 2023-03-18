package com.brower.quantfinance;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication( exclude = {
//		DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class
//})
@SpringBootApplication
@EnableBatchProcessing
public class QuantFinanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuantFinanceApplication.class, args);
	}
}
