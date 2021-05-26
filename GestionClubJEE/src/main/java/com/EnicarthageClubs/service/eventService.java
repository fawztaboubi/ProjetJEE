package com.EnicarthageClubs.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.EnicarthageClubs.model.Event;
import com.EnicarthageClubs.repository.eventRepo;
@Service
public class eventService {
	
	@Autowired
	eventRepo EventRepository;

	@Transactional
	public List<Event> getAllEvents() {
		return (List<Event>) EventRepository.findAll();
	}
	
	//we can a "findByType method here, in the repo first and then use is here

	

	@Transactional
	public Optional<Event> getById(Long id) {
		return EventRepository.findById(id);
	}

	@Transactional
	public void deleteEvent(Long eventId) {
		EventRepository.deleteById(eventId);
	}

	@Transactional
	public boolean addEvent(Event event) {
		return EventRepository.save(event) != null;
	}

	@Transactional
	public boolean updateEvent(Event event) {
		return EventRepository.save(event) != null;
	}

	public void deleteActivity(Long id) {
		// TODO Auto-generated method stub
		
	}

	public List<Event> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}

