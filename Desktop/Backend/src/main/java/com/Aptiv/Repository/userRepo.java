package com.Aptiv.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.Aptiv.Model.User;
// extends JpaRepository<User,Long>
@Repository
public interface userRepo extends JpaRepository<User,Long> {

	
	
	boolean existsByUsername(String username);
	
	User findByUsername(String username);

	boolean findByEmail(String email);

	List<User> findByDepartment(String department);
	
	
	



	

}
