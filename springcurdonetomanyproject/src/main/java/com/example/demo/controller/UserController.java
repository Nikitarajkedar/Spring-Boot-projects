package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.User1;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/userpost")
public class UserController {
@Autowired
private UserService us;
@PostMapping("/add")
public User1 createUser(@RequestBody User1 user) {
	return us.creatUser(user);
}

@GetMapping("/get")
public List<User1> getAllUsers(){
	return us.getAllUsers();
}
@DeleteMapping("/{id}")
public String deleteUser(@PathVariable int id) {
	return us.deleteUser(id);
}

//"uname": "mina kedar",
//"posts": [
//  {          "pid": 5,  "title": "updated full stack -java guide" },
//  {          "pid": 6,"title": "updated Spring boot" }
//  
//]
//}
// when we update the name or title that time pid is also important to write 
@PutMapping("/{id}")
public User1 updateuser(@RequestBody User1 u , @PathVariable int id ) {
	return us.updateUser(u, id);
}
}
