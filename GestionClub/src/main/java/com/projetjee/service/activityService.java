package com.projetjee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.projetjee.model.Activity;
import com.projetjee.repository.activityRepo;

public class activityService {
	
	@Autowired
	activityRepo<Activity> ActivityRepository;

	@Transactional
	public List<Activity> getAllActivities() {
		return (List<Activity>) ActivityRepository.findAll();
	}
	
	//we can a "findByType method here, in the repo first annd then use is here

	@Transactional
	public List<Activity> findByName(String name) {
		return ActivityRepository.findByName(name);
	}

	@Transactional
	public Optional<Activity> getById(Long id) {
		return ActivityRepository.findById(id);
	}

	@Transactional
	public void deleteActivity(Long activityId) {
		ActivityRepository.deleteById(activityId);
	}

	@Transactional
	public boolean addClub(Activity activity) {
		return ActivityRepository.save(activity) != null;
	}

	@Transactional
	public boolean updateActivity(Activity activity) {
		return ActivityRepository.save(activity) != null;
	}

}