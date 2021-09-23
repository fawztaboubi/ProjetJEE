package com.Aptiv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aptiv.Model.ActionPlan;

@Repository
public interface actionPlanRepo extends JpaRepository<ActionPlan, Long>{ 
//we might need these queries to retrieve filtered data
	

}
