package com.hansen.mobileplan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hansen.mobileplan.model.User;

public interface UserDao extends CrudRepository<User, Long>{
	public Iterable<User> findByEmail(String email);
	
}



