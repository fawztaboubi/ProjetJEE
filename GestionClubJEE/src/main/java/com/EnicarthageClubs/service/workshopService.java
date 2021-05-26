package com.EnicarthageClubs.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EnicarthageClubs.repository.workshopRepo;
import com.EnicarthageClubs.model.Workshop;

@Service
public class workshopService {



	@Autowired
	workshopRepo workshopRepository;

	@Transactional
	public List<Workshop> getAllWorkshops() {
		return (List<Workshop>) workshopRepository.findAll();
	}

	

	@Transactional
	public Optional<Workshop> getById(Long id) {
		return workshopRepository.findById(id);
	}

	@Transactional
	public void deleteWorkshop(Long workshopId) {
		workshopRepository.deleteById(workshopId);
	}

	@Transactional
	public boolean addWorkshop(Workshop workshop) {
		return workshopRepository.save(workshop) != null;
	}

	@Transactional
	public boolean updateWorkshop(Workshop workshop) {
		return workshopRepository.save(workshop) != null;
	}



}

