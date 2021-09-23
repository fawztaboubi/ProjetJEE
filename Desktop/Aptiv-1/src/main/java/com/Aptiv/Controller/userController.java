package com.Aptiv.Controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aptiv.Model.User;
import com.Aptiv.Service.userService;
import com.fasterxml.jackson.databind.JsonMappingException;


@CrossOrigin(origins = "*", maxAge=3600, allowedHeaders = "*")
@RestController
@RequestMapping("/users")
//@RequestMapping(value="/api/users/",headers = "Accept=application/json")
public class userController {

	@Autowired
	userService UserService;


    
	// get user by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
	     if (UserService.findById(id)) {
	    	 return new ResponseEntity<>(UserService.getById(id), HttpStatus.OK);
	            
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/username/{username}", produces = "application/json")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
	     if (UserService.findByUsername(username)) {
	    	 return new ResponseEntity<>(UserService.getByUsername(username), HttpStatus.OK);
	            
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	//updated version
	@GetMapping(value="/")
    public ResponseEntity<List<User> > getUsers() {

        if (UserService.getAllUsers().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(UserService.getAllUsers(), HttpStatus.OK);
    }
	
	//get users by department
	@GetMapping(value="/department/{department}")
    public ResponseEntity<List<User> > getUsersByDepartment(@PathVariable String department) {

        if (UserService.getAllUsersByDepartment(department).isEmpty()) {
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(UserService.getAllUsersByDepartment(department), HttpStatus.OK);
       
   }

	// delete user rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {

        if (UserService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    	UserService.deleteUser(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	    }
		
        

	// create user rest api
	
	@PostMapping("/post")
	public boolean createUser(@RequestBody User user) {
		return UserService.addUser(user);
	}
   //why does .save of reposiotry returns a boolean ? 
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> updateUser(@PathVariable Long id, @RequestBody User UserDetails){
       
		if (UserService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		User user=new User();		
		user.setName(UserDetails.getName());
		user.setFamilyName(UserDetails.getFamilyName());
		user.setUsername(UserDetails.getUsername());
		user.setEmail(UserDetails.getEmail());
		user.setAdd_Action(UserDetails.getAdd_Action());
		user.setAdd_Action_Plan(UserDetails.getAdd_Action_Plan());
		user.setModify_Action(UserDetails.getModify_Action());
		user.setModify_Action_Plan(UserDetails.getModify_Action_Plan());
		user.setJob(UserDetails.getJob());
		user.setPassword(UserDetails.getPassword());
		//how to define getters and setters for foreign keys
        //add more setters to userDetails
	    UserService.updateUser(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
