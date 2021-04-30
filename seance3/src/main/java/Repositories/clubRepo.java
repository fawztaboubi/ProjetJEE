package Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Model.Club;


public interface clubRepo  extends CrudRepository<Club, Long> {

}
