 package com.Aptiv.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Aptiv.Model.User;
import com.Aptiv.Repository.userRepo;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class userService {

	@Autowired
	userRepo userRepository;
    
	@Transactional
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}


	@Transactional
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}


	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@ExceptionHandler({HttpMessageNotReadableException.class, JsonMappingException.class, HttpMediaTypeNotSupportedException.class})
	@Transactional
	public boolean addUser(User user) {
		return userRepository.save(user) != null;
	}

	@Transactional
	public boolean updateUser(User user) {
		return userRepository.save(user) != null;
	}

	@Transactional
	public boolean findById(Long id) {
	
		return userRepository.existsById(id);
	}


	public boolean findByUsername(String username) {
		
		return userRepository.existsByUsername(username);
	}


	public User getByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	public List<User>getAllUsersByDepartment(String department){
		return userRepository.findByDepartment(department);
	}

}
