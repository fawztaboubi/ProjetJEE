package com.EnicarthageClubs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EnicarthageClubs.model.Membre;

import java.util.List;

@Repository

public interface membreRepo<P> extends JpaRepository<Membre, Long> {
    List<Membre> findByName(String Name);
}
