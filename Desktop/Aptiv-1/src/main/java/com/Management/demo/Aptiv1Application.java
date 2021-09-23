package com.Management.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
//@EnableWebMvc
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EntityScan("com.Aptiv.Model")
@EnableJpaRepositories("com.Aptiv.Repository")
@ComponentScan({"com.Aptiv.Controller","com.Aptiv.Service","Configuration"})
//@Configuration
public class Aptiv1Application {
 
	public static void main(String[] args) {

		SpringApplication.run(Aptiv1Application.class, args);
	}
	



}
