package com.projetjee.main;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class UniClubManager  {

	public static void main(String[] args) { 
              SpringApplication app = new SpringApplication(UniClubManager.class);
              Map<String, Object> params = new HashMap();
              params.put("server.port","7070");
              app.setDefaultProperties(params);
              app.run(args);
	}

}
