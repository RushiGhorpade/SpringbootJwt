package com.javainuse.dao;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);

	DAOUser findById(long userId);

	DAOUser deleteById(long userId);
	
	

	
}