package com.Aptiv.Controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aptiv.Service.actionService;
import com.Aptiv.Service.themeService;
import com.Aptiv.Model.Action;
import com.Aptiv.Model.Theme;




@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@Controller
@RequestMapping("/actions")
public class actionController {

	@Autowired
	actionService ActionService;
	
	@Autowired
    themeService ThemeService;
	
	
	// get user by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Action>> getActionById(@PathVariable Long id) {
	     if (ActionService.findById(id)) {
	    	 return new ResponseEntity<>(ActionService.getById(id), HttpStatus.OK);
	            
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<List<Action>> getActionByDepartment(@PathVariable String department) {
	     if (ActionService.getAllByDepartment(department).isEmpty()) {
	    	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            
	        }
	     return new ResponseEntity<>(ActionService.getAllByDepartment(department), HttpStatus.OK);
	}
	

	//updated version
	@GetMapping(value="/")
    public ResponseEntity<List<Action> > getUsers() {

        if (ActionService.getAllActions().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ActionService.getAllActions(), HttpStatus.OK);
    }

	// delete user rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {

        if (ActionService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ActionService.deleteAction(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	    }
		
    //get actions by theme
 //  @GetMapping("/theme/{theme}")
//	public ResponseEntity<List<Action>> getActionsByTheme(@PathVariable String theme) {
//	     Theme themeobj= ThemeService.getByName(theme);
	     
//	     if (ActionService.findByTheme(themeobj)) {
//	    	 return new ResponseEntity<>(ActionService.getAllByTheme(themeobj), HttpStatus.OK);
	            
//	        }
//	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}

	// create user rest api
	@PostMapping("/post")
	public boolean createAction(@RequestBody Action action) {
		return ActionService.addAction(action);
	}

	
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> updateUser(@PathVariable Long id, @RequestBody Action ActionDetails){
       
		if (ActionService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		Action action=new Action();		
		action.setProject(ActionDetails.getProject());
        //add more setters to userDetails
		ActionService.updateAction(action);
		Map<String, Boolean> response = new HashMap<>();
		response.put("updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

	
}
