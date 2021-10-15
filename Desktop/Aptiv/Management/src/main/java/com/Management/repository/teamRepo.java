package com.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Management.model.Team;

@Repository
public interface teamRepo extends JpaRepository<Team, Long> {

}
