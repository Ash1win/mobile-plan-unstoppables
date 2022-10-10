package com.hansen.mobileplan.srvc;

import java.util.List;
import java.util.Optional;

import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansen.mobileplan.dao.UserDao;
import com.hansen.mobileplan.model.MobilePlan;
import com.hansen.mobileplan.model.User;

@Service
public class UserSrvc {
	//todo:
	//signin
	//signup
	
	
	@Autowired 
	UserDao userDao;
	
	StrongPasswordEncryptor passswordEncryptor = new StrongPasswordEncryptor();
	
	
	//create
	public Object createUser(User entity) {

		List<User> person = (List<User>) userDao.findByEmail(entity.getEmail());
		User user = null;
		
		if(person.size()==0) {
			user = userDao.save(entity);
		}
		
		return user;
		

	}
	
	//login
	public Object login(User user) {
			
		List<User> person = (List<User>) userDao.findByEmail(user.getEmail());
		
//			boolean result = false;
			
		
			if(person.size()!=0 && passswordEncryptor.checkPassword(user.getPassword(), person.get(0).getPassword())){
//				result = true;
				return person;
			}
			

//			return result;	
			return null;
		}
	
	
}
