package com.javainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.dao.UserDao;
import com.javainuse.model.DAOUser;
import com.javainuse.model.UserDTO;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {
  
	
	@Autowired
	UserDao dao;
	

	
	@RequestMapping({ "/getall" })
   public Iterable<DAOUser> getAllUsers() {
	return this.dao.findAll();
	}
	
	
	@RequestMapping(value="/getall/{id}")
	public DAOUser getUserById(@org.springframework.web.bind.annotation.PathVariable (value = "id") long userId) {
		return this.dao.findById(userId);
}
	
	@PutMapping("/update/{id}")
	public DAOUser updateUser(@RequestBody DAOUser user, @PathVariable ("id") long userId) {
		DAOUser existingUser = dao.findById(userId);
	
		 existingUser.setUsername(user.getUsername());
		 existingUser.setPassword(user.getPassword());
		 existingUser.setFile(user.getFile());
		 return this.dao.save(existingUser);
	}
	
//	
//	@DeleteMapping("/delete/{id}")
//	public DAOUser DeleteUser( @PathVariable ("id") long userId) {
//	 return this.dao.deleteById(userId);
//	}
//	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable ("id") long userId){
		DAOUser existingUser = this.dao.findById(userId);
					
		  this.dao.delete(existingUser);
		 return ResponseEntity.ok().build();
	}
			
     }