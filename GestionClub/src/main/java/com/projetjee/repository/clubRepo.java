package com.projetjee.repository;

import org.springframework.data.repository.CrudRepository;

import com.projetjee.model.Club;

import java.util.List;

public interface clubRepo<P> extends CrudRepository<Club, Long> {
    List<Club> findByName(String Name);
}
