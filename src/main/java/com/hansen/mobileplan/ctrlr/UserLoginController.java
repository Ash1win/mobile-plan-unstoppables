package com.hansen.mobileplan.ctrlr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hansen.mobileplan.dao.UserDao;
import com.hansen.mobileplan.model.User;
import com.hansen.mobileplan.srvc.UserSrvc;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserLoginController {
	//todo: 
	//signup path
	//signin path
	//how to give path => path = "/signin"
	
	
	
//	@Autowired
//	UserSrvc userSrvc;
	
	@Autowired
	UserSrvc userSrvc;
	
	@RequestMapping(method = RequestMethod.POST ,path = "/signup")
	public ResponseEntity<Object> create(@RequestBody User userCreated) {
		ResponseEntity<Object> userResponse;
		
		
		Object user = userSrvc.createUser(userCreated);
	
		if(user!=null) {
			userResponse = new ResponseEntity<>(user, null, HttpStatus.CREATED);
			
		}else {
			userResponse = new ResponseEntity<>("Email Already Exists !!", null, HttpStatus.FORBIDDEN);
			
		}
		
		return userResponse;
	}	
	
	
	
	
	@RequestMapping(method = RequestMethod.POST , path = "/signin" )
	public ResponseEntity<Object> login(@RequestBody User userCreated) {
		ResponseEntity<Object> userResponse;
		
		
		Object user = userSrvc.login(userCreated);
	
		if(user != null) {
			userResponse = new ResponseEntity<>(user, null, HttpStatus.OK);
			
		}else {
			userResponse = new ResponseEntity<>("Cannot Login!!", null, HttpStatus.FORBIDDEN);
			
		}
		
		return userResponse;
	}
}
