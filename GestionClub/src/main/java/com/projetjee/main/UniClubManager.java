package com.projetjee.main;
import java.util.HashMap;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.projetjee.config.*;
import com.projetjee.config.AspectConfig;




@SpringBootApplication
public class UniClubManager  {

	public static void main(String[] args) { 
              SpringApplication app = new SpringApplication(UniClubManager.class);
              AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
              ctx.register(AspectConfig.class, dataConfig.class,webConfig.class);
              Map<String, Object> params = new HashMap();
              params.put("server.port","7070");
              app.setDefaultProperties(params);
              app.run(args);
              
              ctx.close();
	}

}
