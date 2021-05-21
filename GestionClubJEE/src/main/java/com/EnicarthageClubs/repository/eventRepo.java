package com.EnicarthageClubs.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EnicarthageClubs.model.Event;

@Repository
public interface eventRepo<P> extends JpaRepository<Event, Long> {



	List<Event> findByName(String name);




}
