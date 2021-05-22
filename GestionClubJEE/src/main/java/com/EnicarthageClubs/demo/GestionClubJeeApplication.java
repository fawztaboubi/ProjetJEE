package com.EnicarthageClubs.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EntityScan("com.EnicarthageClubs.model")
public class GestionClubJeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionClubJeeApplication.class, args);
	}

}
