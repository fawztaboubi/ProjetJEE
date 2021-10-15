package com.Management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Management.repository.themeRepo;
import com.Management.model.Theme;

@Service
public class themeService {

	@Autowired
	themeRepo themeRepository;
    
	@Transactional
	public List<Theme> getAllThemes() {
		return themeRepository.findAll();
	}

	//@Transactional
	//public List<Club> findByName(String name) {
		//return clubRepository.findByName(name);
	//}

	@Transactional
	public Optional<Theme> getById(Long id) {
		return themeRepository.findById(id);
	}

	@Transactional
	public void deleteTheme(Long themeId) {
		themeRepository.deleteById(themeId);
	}

	@Transactional
	public boolean addTheme(Theme theme) {
		return themeRepository.save(theme) != null;
	}

	@Transactional
	public boolean updateTheme(Theme theme) {
		return themeRepository.save(theme) != null;
	}
}
