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

import com.Aptiv.Model.ActionPlan;
import com.Aptiv.Service.actionPlanService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/actionPlans")
public class actionPlanController {
	
	@Autowired
	actionPlanService ActionPlanService;


	// get user by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ActionPlan>> getActionPlanById(@PathVariable Long id) {
	     if (ActionPlanService.findById(id)) {
	    	 return new ResponseEntity<>(ActionPlanService.getById(id), HttpStatus.OK);
	            
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	

	//updated version
	@GetMapping(value="/")
    public ResponseEntity<List<ActionPlan> > getActionPlans() {

        if (ActionPlanService.getAllActionPlans().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ActionPlanService.getAllActionPlans(), HttpStatus.OK);
    }

	// delete user rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteActionPlan(@PathVariable Long id) {

        if (ActionPlanService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    	ActionPlanService.deleteActionPlan(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	    }
		
        

	// create user rest api
	@PostMapping("/post")
	public boolean createActionPlan(@RequestBody ActionPlan actionPlan) {
		return ActionPlanService.addActionPlan(actionPlan);
	}
   //why does .save of reposiotry returns a boolean ? 
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> updateUser(@PathVariable Long id, @RequestBody ActionPlan ActionPlanDetails){
       
		if (ActionPlanService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
		ActionPlan actionPlan=new ActionPlan();		
		actionPlan.setName(ActionPlanDetails.getName());
        //add more setters to userDetails
		ActionPlanService.updateActionPlan(actionPlan);
		Map<String, Boolean> response = new HashMap<>();
		response.put("updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}

