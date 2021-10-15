package com.Management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Management.repository.teamRepo;
import com.Management.model.Team;

@Service
public class teamService {

	@Autowired
	teamRepo teamRepository;
    
	@Transactional
	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	//@Transactional
	//public List<Club> findByName(String name) {
		//return clubRepository.findByName(name);
	//}

	@Transactional
	public Optional<Team> getById(Long id) {
		return teamRepository.findById(id);
	}

	@Transactional
	public void deleteTeam(Long teamId) {
		teamRepository.deleteById(teamId);
	}

	@Transactional
	public boolean addTeam(Team team) {
		return teamRepository.save(team) != null;
	}

	@Transactional
	public boolean updateTeam(Team team) {
		return teamRepository.save(team) != null;
	}
}
