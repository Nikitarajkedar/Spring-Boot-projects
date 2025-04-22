package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Integer>{

}
