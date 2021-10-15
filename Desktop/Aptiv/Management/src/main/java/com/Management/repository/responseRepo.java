package com.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Management.model.Response;

@Repository
public interface responseRepo extends JpaRepository<Response, Long>{

}
