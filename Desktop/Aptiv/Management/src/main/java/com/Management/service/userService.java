package com.Management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Management.model.User;
import com.Management.repository.userRepo;

@Service
public class userService {

	@Autowired
	userRepo userRepository;
    
	@Transactional
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	//@Transactional
	//public List<Club> findByName(String name) {
		//return clubRepository.findByName(name);
	//}

	@Transactional
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}

	@Transactional
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Transactional
	public boolean addUser(User user) {
		return userRepository.save(user) != null;
	}

	@Transactional
	public boolean updateUser(User user) {
		return userRepository.save(user) != null;
	}
}
