package com.Aptiv.Repository;

import java.util.List;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Aptiv.Model.Action;
import com.Aptiv.Model.Theme;

@Repository
@EnableJpaRepositories
public interface actionRepo  extends JpaRepository<Action, Long> {

	List<Action> findByDepartment(String department);




//	boolean existsByTheme(Theme theme);


//	List<Action> findByTheme(Theme theme);
	

	  
		

}
