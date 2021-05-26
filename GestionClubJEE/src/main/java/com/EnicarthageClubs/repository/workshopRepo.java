package com.EnicarthageClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EnicarthageClubs.model.Workshop;

@Repository
public interface workshopRepo extends JpaRepository<Workshop, Long> {

}
