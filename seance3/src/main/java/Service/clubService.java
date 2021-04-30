package Service;

import java.util.List;
import java.util.Optional;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import Model.Club;
import Repositories.Crepo;
import Repositories.clubRepo;

@Service("clubService")
public class clubService{
	
	@Autowired
	private Crepo repository;

		
		@Transactional
		public Club saveClub(Club club) {
			Club clubresponse = (Club) repository.save(club);
			return clubresponse;
		}

		
	}


