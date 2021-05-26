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

import com.EnicarthageClubs.model.Workshop;
import com.EnicarthageClubs.service.workshopService;
@RestController
public class workshopController {
	@Autowired
	workshopService WorkshopService;

	@RequestMapping(value = "/workshop/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Workshop> getAllClubs(@PathVariable Long id) {
		return WorkshopService.getById(id);
	}

	//@RequestMapping(value = "/membreByName/{name}", method = RequestMethod.GET)
	//public List<Membre> getMembreByName(@PathVariable String name) {
		//return MembreService.findByName(name);
	//}

	@RequestMapping(value = "/workshop", method = RequestMethod.GET)
	public List<Workshop> getAll() {
		return WorkshopService.getAllWorkshops();
	}

	@RequestMapping(value = "/workshop/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteWorkshop(@PathVariable Long id) {
		WorkshopService.deleteWorkshop(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/workshop", method = RequestMethod.POST)
	public HttpStatus insertWorkshop(@RequestBody Workshop workshop) {
		return WorkshopService.addWorkshop(workshop) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/workshop", method = RequestMethod.PUT)
	public HttpStatus updateWorkshop(@RequestBody Workshop workshop) {
		return WorkshopService.updateWorkshop(workshop) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

}
