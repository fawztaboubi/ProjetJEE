package com.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Management.model.Action;

@Repository
public interface actionRepo  extends JpaRepository<Action, Long> {
	   //public List<Club> findByName(String name);
	
	
	

}
