package com.Aptiv.Controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aptiv.Model.Department;
import com.Aptiv.Service.departmentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/departments")
public class departmentController {

	@Autowired
	departmentService DepartmentService;


	// get user by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Department>> getUserById(@PathVariable Long id) {
	     if (DepartmentService.findById(id)) {
	    	 return new ResponseEntity<>(DepartmentService.getById(id), HttpStatus.OK);
	            
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Department> getDepartmentByName(@PathVariable String name) {
	     if (DepartmentService.findByName(name)) {
	    	 
	    	 return new ResponseEntity<>(DepartmentService.getByName(name), HttpStatus.OK);
	 
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	//updated version
	@GetMapping(value="/")
    public ResponseEntity<List<Department> > getAllDepartments() {

        if (DepartmentService.getAllDepartments().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(DepartmentService.getAllDepartments(), HttpStatus.OK);
    }

	// delete user rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {

        if (DepartmentService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        DepartmentService.deleteDepartment(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	    }
		
        

	// create user rest api
	@PostMapping("/post")
	public boolean createDepartment(@RequestBody Department department) {
		return DepartmentService.addDepartment(department);
	}
   //why does .save of reposiotry returns a boolean ? 
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> updateUser(@PathVariable Long id, @RequestBody Department DepartmentDetails){
       
		if (DepartmentService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		Department user=new Department();		
		user.setName(DepartmentDetails.getName());
        //add more setters to userDetails
	    DepartmentService.updateDepartment(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
