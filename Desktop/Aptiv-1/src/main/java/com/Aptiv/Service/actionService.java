package com.Aptiv.Service;

import java.util.Arrays;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aptiv.Model.Action;
import com.Aptiv.Model.Theme;
import com.Aptiv.Repository.actionRepo;

@Service
public class actionService {

	@Autowired
	actionRepo actionRepository;
	
	@Transactional
	public List<Action> getAllActions() {
		return actionRepository.findAll();
	}

	//@Transactional
	//public List<Action> findByProject(String project) {
		//return actionRepository.findByProject(project);
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

	public boolean findById(Long id) {
		
		return actionRepository.existsById(id);
	}

//	public boolean findByTheme(Theme theme) {
		
//		return actionRepository.existsByTheme(theme);
//	}

//	public List<Action> getAllByTheme(Theme theme) {
		
//		return actionRepository.findByTheme(theme);
//	}
	
	public List<Action> getAllByDepartment(String department){
		return actionRepository.findByDepartment(department);
	}


	
	
}
