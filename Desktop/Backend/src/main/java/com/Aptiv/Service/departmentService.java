package com.Aptiv.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aptiv.Model.Department;
import com.Aptiv.Repository.departmentRepo;

@Service
public class departmentService {

	@Autowired
	departmentRepo departmentRepository;
	
	@Transactional
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Transactional
	public Optional<Department> getById(Long id) {
		return departmentRepository.findById(id);
	}

	@Transactional
	public Department getByName(String name) {
		return departmentRepository.findByName(name);
	}
	@Transactional
	public void deleteDepartment(Long actionId) {
		departmentRepository.deleteById(actionId);
	}

	@Transactional
	public boolean addDepartment(Department action) {
		return departmentRepository.save(action) != null;
	}

	@Transactional
	public boolean updateDepartment(Department action) {
		return departmentRepository.save(action) != null;
	}

	public boolean findById(Long id) {
	
		return departmentRepository.existsById(id);
	}

	public boolean findByName(String name) {
		return departmentRepository.existsByName(name);
	}
}
