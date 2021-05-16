package com.projetjee.repository;

import org.springframework.data.repository.CrudRepository;

import com.projetjee.model.Membre;

import java.util.List;

public interface membreRepo<P> extends CrudRepository<Membre, Long> {
    List<Membre> findByName(String Name);
}
