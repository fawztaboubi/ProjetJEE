package com.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Management.model.User;

@Repository
public interface userRepo extends JpaRepository<User,Long> {

}
