package com.projetjee.repository;

import org.springframework.data.repository.CrudRepository;

import com.projetjee.model.Activity;

import java.util.List;

public interface activityRepo<P> extends CrudRepository<Activity, Long> {
    List<Activity> findByName(String Name);
}
