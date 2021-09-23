package com.Aptiv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aptiv.Model.Request;

@Repository
public interface requestRepo  extends JpaRepository<Request, Long> {

}
