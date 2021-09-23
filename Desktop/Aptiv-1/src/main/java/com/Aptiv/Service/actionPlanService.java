package com.Aptiv.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aptiv.Model.ActionPlan;
import com.Aptiv.Repository.actionPlanRepo;

@Service
public class actionPlanService {
	
	@Autowired
	actionPlanRepo actionPlanRepository;
	
	@Transactional
	public List<ActionPlan> getAllActionPlans() {
		return actionPlanRepository.findAll();
	}

	//@Transactional
	//public List<Club> findByName(String name) {
		//return clubRepository.findByName(name);
	//}

	@Transactional
	public Optional<ActionPlan> getById(Long id) {
		return actionPlanRepository.findById(id);
	}

	@Transactional
	public void deleteActionPlan(Long actionPlanId) {
		actionPlanRepository.deleteById(actionPlanId);
	}

	@Transactional
	public boolean addActionPlan(ActionPlan actionPlan) {
		return actionPlanRepository.save(actionPlan) != null;
	}

	@Transactional
	public boolean updateActionPlan(ActionPlan actionPlan) {
		return actionPlanRepository.save(actionPlan) != null;
	}

	public boolean findById(Long id) {
		
		return actionPlanRepository.existsById(id);
	}
}
