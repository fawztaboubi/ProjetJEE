package com.projetjee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetjee.model.Activity;
import com.projetjee.service.activityService;

public class activityController {

	
	@Autowired
	activityService ActivityService;

	@RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Activity> getAllClubs(@PathVariable Long id) {
		return ActivityService.getById(id);
	}

	//we will add other methods specific to events, meetings and workshop
	
	@RequestMapping(value = "/activityByName/{name}", method = RequestMethod.GET)
	public List<Activity> getActivityByName(@PathVariable String name) {
		return ActivityService.findByName(name);
	}

	@RequestMapping(value = "/activity", method = RequestMethod.GET)
	public List<Activity> getAll() {
		return ActivityService.getAllActivities();
	}

	@RequestMapping(value = "/activity/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteClub(@PathVariable Long id) {
		ActivityService.deleteActivity(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/activity", method = RequestMethod.POST)
	public HttpStatus insertActivity(@RequestBody Activity activity) {
		return ActivityService.addClub(activity) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/activity", method = RequestMethod.PUT)
	public HttpStatus updateActivity(@RequestBody Activity activity) {
		return ActivityService.updateActivity(activity) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
}
