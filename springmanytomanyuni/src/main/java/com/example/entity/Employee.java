package com.example.entity;

import java.util.HashSet;
import java.util.Set;
import com.example.entity.Projects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	

	/*
	 *  1.CascadeType.PERSIST Meaning: When you save (persist) the parent entity, its
	 * associated child entities are also saved automatically.
	 * 
	 *  2. CascadeType.MERGE Meaning: When the parent entity is updated (merged), its 
	 *  associated child entities are also updated.
	 *  
	 *  3. CascadeType.REMOVE Meaning: When the parent entity is deleted, its 
	 *  associated child entities are also deleted.
	 * 
	 */
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinTable(
	name = "employee_projects")
	private Set<Projects> projects=new HashSet<>();



	public Integer getEmpId() {
		return empId;
	}



	public void setEmpId(Integer empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public Set<Projects> getProjects() {
		return projects;
	}



	public void setProjects(Set<Projects> projects) {
		this.projects = projects;
	}


	
	
	
}

