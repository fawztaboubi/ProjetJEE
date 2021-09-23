package com.Aptiv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aptiv.Model.Department;

@Repository
public interface departmentRepo extends JpaRepository<Department, Long> {

	Department findByName(String name);

	boolean existsByName(String name);

}
