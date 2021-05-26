package com.EnicarthageClubs.demo;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EntityScan("com.EnicarthageClubs.model")
@EnableJpaRepositories("com.EnicarthageClubs.repository")
@ComponentScan({"com.EnicarthageClubs.controller","com.EnicarthageClubs.service"})
public class GestionClubJeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionClubJeeApplication.class, args);
	}

}
