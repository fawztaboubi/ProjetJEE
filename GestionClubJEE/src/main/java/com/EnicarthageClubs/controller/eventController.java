package com.EnicarthageClubs.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.EnicarthageClubs.model.Event;
import com.EnicarthageClubs.service.eventService;
@RestController
public class eventController {

	
	@Autowired
	eventService EventService;

	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Event> getAllEvents(@PathVariable Long id) {
		return EventService.getById(id);
	}

	//we will add other methods specific to events, meetings and workshop
	
	@RequestMapping(value = "/activityByName/{name}", method = RequestMethod.GET)
	public List<Event> getActivityByName(@PathVariable String name) {
		return EventService.findByName(name);
	}

	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public List<Event> getAll() {
		return EventService.getAllEvents();
	}

	@RequestMapping(value = "/activity/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteClub(@PathVariable Long Id) {
		EventService.deleteActivity(Id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/activity", method = RequestMethod.POST)
	public HttpStatus insertEvent(@RequestBody Event event) {
		return EventService.addEvent(event) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/activity", method = RequestMethod.PUT)
	public HttpStatus updateEvent(@RequestBody Event event) {
		return EventService.updateEvent(event) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
}
