package com.mqds.cloudpark;
//https://parking-tchelo.herokuapp.com/
//flyway spring -> migração de banco de dados em produção

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudParkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudParkApplication.class, args);
	}

}
