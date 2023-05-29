package com.spring.webservice.restapi.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserController {
	@Autowired
	private UserService service;
    @GetMapping(path="/users")
	public List<User> getUsers(){
    	return service.findAll();
    }
    @GetMapping(path="/users/{id}")
	public User getUserById(@PathVariable int id){
    	User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		
		return user;
    }
//    @PostMapping("/users")
//	public User createUser(@RequestBody User user) {
//		return service.save(user);
//	}
    @PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		service.save(user);
		int resId = user.getId();
		URI locationId =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resId).toUri();
		return ResponseEntity.created(locationId).build();
	}
    @DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
    
}
