package com.EnicarthageClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EnicarthageClubs.model.Meeting;

@Repository
public interface meetingRepo extends JpaRepository<Meeting, Long> {
	
}
