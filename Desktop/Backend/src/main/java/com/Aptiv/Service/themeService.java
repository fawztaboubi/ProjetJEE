package com.Aptiv.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aptiv.Model.Department;
import com.Aptiv.Model.Theme;
import com.Aptiv.Repository.themeRepo;

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
	public Optional<Theme>getById(Long id) {
		return themeRepository.findById(id);
	}
	
	@Transactional
	public Theme getByName(String name) {
		return themeRepository.findByName(name);
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

	public boolean findById(Long id) {
	
		return themeRepository.existsById(id);
	}
	
	//public List<Theme> getAllByDepartment(Department department){
		//return themeRepository.themesPerDeparment(department);
	//}
}
