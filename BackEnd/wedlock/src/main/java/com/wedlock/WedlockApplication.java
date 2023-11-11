package com.wedlock;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages="com.dao")
@EntityScan(basePackages="com.model")

@SpringBootApplication(scanBasePackages="com")
public class WedlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(WedlockApplication.class, args);
	}

}
