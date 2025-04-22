package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post1 {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pid;
private String title;

 @ManyToOne
@JoinColumn(name = "user_id")
@JsonBackReference
private User1 user1;

//Getters and Setters
public int getPid() {
	return pid;
}
	public void setPid(int pid) {
	this.pid = pid;
}
public String getTitle() {
	return title;
}
public void setTitle(String pname) {
	this.title = pname;
}
public User1 getUser1() {
	return user1;
}
public void setUser1(User1 user1) {
	this.user1 = user1;
}


}
