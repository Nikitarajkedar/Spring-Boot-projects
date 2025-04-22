package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired 
	private UserService as;

	@GetMapping("/all")
	public List<User> getAllUsers() {
    return as.getUser();
	}

//
//http://localhost:8080/user/add
//{
//    "uname":"nikita kedar",
//    "profile":{
//    "phoneNo":"7758996411",
//    "address":"pune"
//    }
//  }
  
//				        ^
// to add data base data|

	@PostMapping ("/add")
	public User addUser(@RequestBody  User a)
	{
	return as.addUser(a);
			
	}

	@PutMapping("update/{id}")
	public User updateuser(@RequestBody User u , @PathVariable int id ) {
		return as.UpdateUser(u, id);
	}
	@GetMapping("/{id}")
	public User getUser(@PathVariable int  id) {
    return as.getUserById(id);
	}
// delete the record
	@DeleteMapping("del/{id}")
	public String deletedUser(@PathVariable int id)
	{
		return as.deletebyId(id);
	}
	
	
}
