package com.Aptiv.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.Aptiv.Model.Response;
import com.Aptiv.Service.EmailSender;

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping("/emails")
public class EmailSenderController {

	@Autowired
	private EmailSender service;
	
	
	@PostMapping("/reply")
	public ResponseEntity<Map<String, Boolean>> triggerMail(@RequestBody Response response)throws MessagingException{
		
		String toEmail=response.getToEmail();
		String body="you have been added to "+response.getDepartment()+" department. You can login to workspace using the following credentials:"
				     + "username: "+response.getUsername()+"/n"+"password: "+response.getPassword();
		String subject="Request Processed";
		service.sendSimpleEmail(toEmail, body, subject);
		
		Map<String, Boolean> res = new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
	
	  



}
