package com.projetjee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.projetjee.model.Membre;
import com.projetjee.repository.membreRepo;

public class membreService {

	@Autowired
	membreRepo<Membre> membreRepository;

	@Transactional
	public List<Membre> getAllMembres() {
		return (List<Membre>) membreRepository.findAll();
	}

	@Transactional
	public List<Membre> findByName(String name) {
		return membreRepository.findByName(name);
	}

	@Transactional
	public Optional<Membre> getById(Long id) {
		return membreRepository.findById(id);
	}

	@Transactional
	public void deleteMembre(Long clubId) {
		membreRepository.deleteById(clubId);
	}

	@Transactional
	public boolean addMembre(Membre membre) {
		return membreRepository.save(membre) != null;
	}

	@Transactional
	public boolean updateMembre(Membre membre) {
		return membreRepository.save(membre) != null;
	}



}
