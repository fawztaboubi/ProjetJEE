package com.Aptiv.Repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Aptiv.Model.Theme;

@Repository
public interface themeRepo extends JpaRepository <Theme,Long>{

	Theme findByName(String name);

//	@Query(value = "SELECT the FROM theme WHERE theme.department.id = department.id;")
	//List<Theme> themesPerDeparment(Department department);

}
