package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositary.UserRepositary;

@Service
public class UserService {
	@Autowired
	private UserRepositary userRepository;

	public List<User> getUser() {

		return userRepository.findAll(); //data find data karan like data base se
	}

	public User addUser(User a)
	{
		return userRepository.save(a);	//save on data base
	}

public User UpdateUser(User u,int id) {
	u.setUid(id);
	return userRepository.save(u);
}

public String deletebyId(int id) {
 User u=userRepository.getById(id);
 userRepository.delete(u);
	return "user deleted"	;
}
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}



}

