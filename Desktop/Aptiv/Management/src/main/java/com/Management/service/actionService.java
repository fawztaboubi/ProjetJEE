package com.Management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Management.model.Action;
import com.Management.repository.actionRepo;

//un action can be deleted added and upadated 
@Service
public class actionService {

	@Autowired
	actionRepo actionRepository;
	
	@Transactional
	public List<Action> getAllActions() {
		return actionRepository.findAll();
	}

	//@Transactional
	//public List<Club> findByName(String name) {
		//return clubRepository.findByName(name);
	//}

	@Transactional
	public Optional<Action> getById(Long id) {
		return actionRepository.findById(id);
	}

	@Transactional
	public void deleteAction(Long actionId) {
		actionRepository.deleteById(actionId);
	}

	@Transactional
	public boolean addAction(Action action) {
		return actionRepository.save(action) != null;
	}

	@Transactional
	public boolean updateAction(Action action) {
		return actionRepository.save(action) != null;
	}
}
