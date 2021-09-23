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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aptiv.Model.Department;
import com.Aptiv.Model.Theme;
import com.Aptiv.Service.themeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/themes")
public class themeController {
	
	@Autowired
	themeService ThemeService;


	// get user by id rest api
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Theme>> getThemeById(@PathVariable Long id) {
	     if (ThemeService.findById(id)) {
	    	 return new ResponseEntity<>(ThemeService.getById(id), HttpStatus.OK);
	            
	        }
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

	//updated version
	@GetMapping(value="/")
    public ResponseEntity<List<Theme> > getThemes() {

        if (ThemeService.getAllThemes().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ThemeService.getAllThemes(), HttpStatus.OK);
    }

	// delete user rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {

        if (ThemeService.getById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    	ThemeService.deleteTheme(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	    }
		
        

	// create user rest api
	@PostMapping("/")
	public boolean createTheme(@RequestBody Theme theme) {
		return ThemeService.addTheme(theme);
	}
   //why does .save of reposiotry returns a boolean ? 
	
	//define get all themes by department method
//	@GetMapping(value="/api/themes/{department}")
//    public ResponseEntity<List<Theme> > getThemesByDepartment(@PathVariable Department department) {

//        if (ThemeService.getAllByDepartment(department).isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
 //       return new ResponseEntity<>(ThemeService.getAllByDepartment(department), HttpStatus.OK);
//    }


}
