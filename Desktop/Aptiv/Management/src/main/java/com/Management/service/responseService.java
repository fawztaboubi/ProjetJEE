package com.Management.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Management.repository.responseRepo;
import com.Management.model.Response;

@Service
public class responseService {

	@Autowired
	responseRepo responseRepository;
    
	@Transactional
	public List<Response> getAllResponses() {
		return responseRepository.findAll();
	}

	//@Transactional
	//public List<Club> findByName(String name) {
		//return clubRepository.findByName(name);
	//}

	@Transactional
	public Optional<Response> getById(Long id) {
		return responseRepository.findById(id);
	}

	@Transactional
	public void deleteResponse(Long responseId) {
		responseRepository.deleteById(responseId);
	}

	@Transactional
	public boolean addResponse(Response response) {
		return responseRepository.save(response) != null;
	}

	@Transactional
	public boolean updateResponse(Response response) {
		return responseRepository.save(response) != null;
	}
}