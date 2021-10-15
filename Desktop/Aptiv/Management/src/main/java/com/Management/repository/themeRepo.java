package com.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Management.model.Theme;

@Repository
public interface themeRepo extends JpaRepository <Theme,Long>{

}
