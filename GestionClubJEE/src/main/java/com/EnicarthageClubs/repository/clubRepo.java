package com.EnicarthageClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EnicarthageClubs.model.Club;

import java.util.List;
@Repository
public interface clubRepo<P> extends JpaRepository<Club, Long> {
    List<Club> findByName(String Name);
}
