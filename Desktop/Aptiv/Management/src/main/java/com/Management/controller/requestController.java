package com.Management.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Management.model.Request;
import com.Management.service.requestService;


@RestController
public class requestController {

	@Autowired
	requestService RequestService;

	@RequestMapping(value = "/checkAllRequests/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Request> getAllRequests(@PathVariable Long id) {
		return RequestService.getById(id);
	}

	//@RequestMapping(value = "/clubByName/{name}", method = RequestMethod.GET)
	//public List<Club> getClubByName(@PathVariable String Name) {
		//return ClubService.findByName(Name);
	//}

	@RequestMapping(value = "/checkThisRequest", method = RequestMethod.GET)
	public List<Request> getAll() {
		return RequestService.getAllRequests();
	}
	//updated version
	@GetMapping(value="/requests")
    public ResponseEntity<List<Request> > getRequest() {

        if (RequestService.getAllRequests().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(RequestService.getAllRequests(), HttpStatus.OK);
    }

	@RequestMapping(value = "/deleteRequest/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteRequest(@PathVariable int id) {
		RequestService.deleteRequest(Long.valueOf(id));
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/insertingRequest", method = RequestMethod.POST)
	public HttpStatus insertRequest(@RequestBody Request request) {
	    
		return RequestService.addRequest(request) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}


}
