package com.Management.controller;

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
import com.Management.model.Action;
import com.Management.service.actionService;

@RestController
public class actionController {

	@Autowired
	actionService ActionService;

	@RequestMapping(value = "/checkAllActions/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Action> getAllActions(@PathVariable Long id) {
		return ActionService.getById(id);
	}

	//@RequestMapping(value = "/clubByName/{name}", method = RequestMethod.GET)
	//public List<Club> getClubByName(@PathVariable String Name) {
		//return ClubService.findByName(Name);
	//}

	@RequestMapping(value = "/checkThisClub", method = RequestMethod.GET)
	public List<Action> getAll() {
		return ActionService.getAllActions();
	}
	//updated version
	@GetMapping(value="/actions")
    public ResponseEntity<List<Action> > getActions() {

        if (ActionService.getAllActions().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ActionService.getAllActions(), HttpStatus.OK);
    }

	@RequestMapping(value = "/deleteAction/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteAction(@PathVariable int id) {
		ActionService.deleteAction(Long.valueOf(id));
		return HttpStatus.NO_CONTENT;
	}

	@RequestMapping(value = "/insertingAction", method = RequestMethod.POST)
	public HttpStatus insertAction(@RequestBody Action action) {
	    
		return ActionService.addAction(action) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/updatingAction", method = RequestMethod.PUT)
	public HttpStatus updateAction(@RequestBody Action action) {
		return ActionService.updateAction(action) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
}
