 package com.Aptiv.Controller;

import java.util.HashMap;



import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aptiv.Model.Request;
import com.Aptiv.Service.requestService;



@CrossOrigin(origins = "http://localhost:4200", maxAge=3600, allowedHeaders = "*")
@RestController
@RequestMapping("/requests")
public class requestController {

	@Autowired
	requestService RequestService;


	// get request by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Request>> getRequestById(@PathVariable Long id) {
	     if (RequestService.findById(id)) {
	    	 return new ResponseEntity<>(RequestService.getById(id), HttpStatus.OK);
	            
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	


	//updated version
	@GetMapping(value="/")
    public ResponseEntity<List<Request> > getRequests() {

        if (RequestService.getAllRequests().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RequestService.getAllRequests(), HttpStatus.OK);
    }

	// delete user rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Long id) {

        if (RequestService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    	RequestService.deleteRequest(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	    }
		
   
	@PostMapping(value="/post")
	public boolean createRequest(@RequestBody Request request) {
		return RequestService.addRequest(request);
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, Boolean>> updateRequest(@PathVariable Long id, @RequestBody Request RequestDetails){
       
		if (RequestService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		Request request=new Request();		
		request.setName(RequestDetails.getName());
		request.setJob(RequestDetails.getJob());
		request.setFamilyName(RequestDetails.getFamilyName());
		request.setStatus(RequestDetails.getStatus());
		request.setEmail(RequestDetails.getEmail());
		request.setId(RequestDetails.getId());
        //add more setters to userDetails
		RequestService.updateRequest(request);
	    RequestService.deleteRequest(id);
		Map<String, Boolean> reponse = new HashMap<>();
		reponse.put("updated", Boolean.TRUE);
		return ResponseEntity.ok(reponse);
	}
	
	



}
