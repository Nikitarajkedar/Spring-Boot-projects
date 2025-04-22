package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User1;
import com.example.demo.repositary.UserRepositary;

@Service
public class UserService {
@Autowired
private UserRepositary ur;
// create user
public User1 creatUser(User1 user) {
	return ur.save(user);
}
// get all user
public List<User1> getAllUsers(){
	return ur.findAll();
	
}

// delete user
public String deleteUser(int id)
{
	if(ur.existsById(id)) {
		ur.deleteById(id);
	return  "user deleted";
	}
	return "user not found ";
	
}
// delete post
public boolean deletePost(int id)
{
	if(ur.existsById(id)) {
		ur.deleteById(id);
	}
	return true;	
}
public User1 updateUser(User1 user,int id) {
	       user.setUid(id);
			return ur.save(user);
}


}
