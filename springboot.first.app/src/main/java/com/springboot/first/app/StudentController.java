package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	//http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Ramesh", "Bind");
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Smith", "jon"));
		students.add(new Student("William", "Adams"));
		students.add(new Student("Hill", "Flores"));
		students.add(new Student("Jones", "Davis"));
		students.add(new Student("Antonio", "Jhone"));	
		return students;
	}
	
	//http://localhost:8080/student/1
	//@PathVariable annotation 
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName,
			          @PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);		
	}
	
	//built rest API to handle query parameter
	//http://http://localhost:8080/student/query?firstName=Smith&lastName=jon
	@GetMapping("/student/query")
	public Student studentQueryParam(
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName) {
		return new Student(firstName, lastName);	
	}
}
