package com.nuttawut.registationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class RegistationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistationServiceApplication.class, args);
	}

}
