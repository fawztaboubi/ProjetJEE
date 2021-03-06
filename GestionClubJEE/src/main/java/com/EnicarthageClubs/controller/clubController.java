package com.EnicarthageClubs.controller;

import java.util.List;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.EnicarthageClubs.model.Club;
import com.EnicarthageClubs.service.clubService;

@RestController
public class clubController {

    @Autowired
	clubService ClubService;

	@RequestMapping(value = "/checkAllAlubs/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Club> getAllClubs(@PathVariable Long id) {
		return ClubService.getById(id);
	}

	//@RequestMapping(value = "/clubByName/{name}", method = RequestMethod.GET)
	//public List<Club> getClubByName(@PathVariable String Name) {
		//return ClubService.findByName(Name);
	//}

	@RequestMapping(value = "/checkThisClub", method = RequestMethod.GET)
	public List<Club> getAll() {
		return ClubService.getAllClubs();
	}
	//updated version
	@GetMapping(value="/clubs")
    public ResponseEntity<List<Club> > getClubs() {

        if (ClubService.getAllClubs().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ClubService.getAllClubs(), HttpStatus.OK);
    }

	@RequestMapping(value = "/deleteClub/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteClub(@PathVariable int id) {
		ClubService.deleteClub(Long.valueOf(id));
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/insertingClub", method = RequestMethod.POST)
	public HttpStatus insertClub(@RequestBody Club club) {
	    
		return ClubService.addClub(club) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/updatingClub", method = RequestMethod.PUT)
	public HttpStatus updateClub(@RequestBody Club club) {
		return ClubService.updateClub(club) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
}
