package com.EnicarthageClubs.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.EnicarthageClubs.model.Club;


@Repository
public interface clubRepo extends JpaRepository<Club, Long> {
   //public List<Club> findByName(String name);
	
	
}
