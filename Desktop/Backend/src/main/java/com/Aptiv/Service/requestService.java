package com.Aptiv.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aptiv.Model.Request;
import com.Aptiv.Repository.requestRepo;

@Service
public class requestService {

	@Autowired
	requestRepo requestRepository;

	@Transactional
	public boolean addRequest(Request request) {
		return requestRepository.save(request) != null;
	}
	
	@Transactional
	public Optional<Request> getById(Long id) {
		return requestRepository.findById(id);
	}
    
	@Transactional
	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}
	
	@Transactional
	public  void deleteRequest(Long requestId) {
		requestRepository.deleteById(requestId);
	}

	public boolean findById(Long id) {

		return requestRepository.existsById(id);
	}

	public boolean updateRequest(Request request) {
		return requestRepository.save(request) != null;
		
	}

}
