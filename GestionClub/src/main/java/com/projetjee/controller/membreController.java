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


import com.projetjee.model.Membre;
import com.projetjee.service.membreService;

public class membreController {

	
	@Autowired
	membreService MembreService;

	@RequestMapping(value = "/membre/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Membre> getAllClubs(@PathVariable Long id) {
		return MembreService.getById(id);
	}

	@RequestMapping(value = "/membreByName/{name}", method = RequestMethod.GET)
	public List<Membre> getMembreByName(@PathVariable String name) {
		return MembreService.findByName(name);
	}

	@RequestMapping(value = "/membre", method = RequestMethod.GET)
	public List<Membre> getAll() {
		return MembreService.getAllMembres();
	}

	@RequestMapping(value = "/membre/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteMembre(@PathVariable Long id) {
		MembreService.deleteMembre(id);
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/membre", method = RequestMethod.POST)
	public HttpStatus insertMembre(@RequestBody Membre membre) {
		return MembreService.addMembre(membre) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/membre", method = RequestMethod.PUT)
	public HttpStatus updateMembre(@RequestBody Membre membre) {
		return MembreService.updateMembre(membre) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}

}
