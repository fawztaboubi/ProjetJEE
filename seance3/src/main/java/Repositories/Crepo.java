package Repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import Model.Club;

@Repository
public class Crepo implements clubRepo{
   
	

	public <S extends Club> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Club> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Club> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<Club> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Club entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll(Iterable<? extends Club> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public <S extends Club> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
