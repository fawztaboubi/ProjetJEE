package com.projetjee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.projetjee.model.Club;
import com.projetjee.repository.clubRepo;

public class clubService {
	
	@Autowired
	clubRepo<Club> clubRepository;

	@Transactional
	public List<Club> getAllClubs() {
		return (List<Club>) clubRepository.findAll();
	}

	@Transactional
	public List<Club> findByName(String name) {
		return clubRepository.findByName(name);
	}

	@Transactional
	public Optional<Club> getById(Long id) {
		return clubRepository.findById(id);
	}

	@Transactional
	public void deleteClub(Long clubId) {
		clubRepository.deleteById(clubId);
	}

	@Transactional
	public boolean addClub(Club club) {
		return clubRepository.save(club) != null;
	}

	@Transactional
	public boolean updateClub(Club club) {
		return clubRepository.save(club) != null;
	}

}
