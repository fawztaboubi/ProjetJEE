package com.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Management.model.Request;

@Repository
public interface requestRepo  extends JpaRepository<Request, Long> {

}
