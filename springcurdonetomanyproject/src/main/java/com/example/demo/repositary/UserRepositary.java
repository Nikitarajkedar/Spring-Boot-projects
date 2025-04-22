package com.example.demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User1;

public interface UserRepositary extends JpaRepository<User1, Integer>{

}
