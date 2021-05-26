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

import com.EnicarthageClubs.model.Meeting;
import com.EnicarthageClubs.service.meetingService;


public class meetingController {

	@Autowired
	meetingService MeetingService;

	@RequestMapping(value = "/meeting/{id}", method = RequestMethod.GET)
	
	public @ResponseBody Optional<Meeting> getAllClubs(@PathVariable Long id) {
		return MeetingService.getById(id);
	}

	//@RequestMapping(value = "/membreByName/{name}", method = RequestMethod.GET)
	//public List<Membre> getMembreByName(@PathVariable String name) {
		//return MembreService.findByName(name);
	//}

	@RequestMapping(value = "/getmeeting", method = RequestMethod.GET)
	public List<Meeting> getAll() {
		return MeetingService.getAllMeetings();
	}

	@RequestMapping(value = "/deleteameeting/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteMeeting(@PathVariable Long id) {
		MeetingService.deleteMeeting(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/insertameeting", method = RequestMethod.POST)
	public HttpStatus insertMeeting(@RequestBody Meeting meeting) {
		return MeetingService.addMeeting(meeting) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/updatemeeting", method = RequestMethod.PUT)
	public HttpStatus updateMeeting(@RequestBody Meeting meeting) {
		return MeetingService.updateMeeting(meeting) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
