package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.entity.Projects;
import com.example.repo.EmployeeRepository;
import com.example.repo.ProjectsRepository;

@RestController
@RequestMapping("/api")
public class EmployeeProjectsController {
	@Autowired
	private EmployeeRepository employeeRepository;

	/*for inserting records:
	 * {
	 * 
	 * "empName": "Nikita Patil", "projects": [{
	 * "projectName":" Upadated ATM management system" },{
	 * "projectName":" Updated File handling" }
	 * 
	 * ] }
	 */
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
	return employeeRepository.save(employee);
	}
	
	@DeleteMapping("/del/{id}")
    public void deleteEmp(@PathVariable int id) {
        employeeRepository.deleteById(id);
    }
	
	/*http://localhost:8080/api/update/6
	 * {
	 * 
	 * "empName": "Nikita Patil", "projects": [{ "projectId":5,
	 * "projectName":" Upadated ATM management system" },{ "projectId":6,
	 * "projectName":" Updated File handling" }
	 * 
	 * ] }
	 */

	@PutMapping("update/{id}")
	public Employee updateEmp(@PathVariable int id,@RequestBody Employee updatedEmp) {
        return employeeRepository.findById(id)
                .map(existingEmp -> {
                    existingEmp.setEmpName(updatedEmp.getEmpName());
                    existingEmp.setProjects(updatedEmp.getProjects()) ;// Update associated projects
                    return employeeRepository.save(existingEmp);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

	
}

