package ca.sheridancollege.karakow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.karakow.beans.Student;
import ca.sheridancollege.karakow.database.DatabaseAccess;

@Controller
public class StudentController {
	
	@Autowired
	DatabaseAccess da;

	@GetMapping("/")
	private String goHome(Model model) {
		
		
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		
//		da.insertStudent();
		
		return ("index");
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @RequestParam String name) {
		
		da.insertStudent(name);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		
		return ("index");
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(Model model, @PathVariable Long id) {
		
		da.deleteStudent(id);
		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		
		return "index";
	}
	
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(Model model, @PathVariable Long id,
			@PathVariable String name) {
		
		Student student = da.getStudentById(id).get(0);
		
		da.updateStudent(id, name);
		
		model.addAttribute("student", student);
		model.addAttribute("studentList", da.getStudents());
		
		return "index";
	}
	
	@GetMapping("/editStudent/{id}")
	public String editStudent(Model model, @PathVariable Long id) {
		
		Student student = da.getStudentById(id).get(0); //retaining the record before deleting it
		
		da.deleteStudent(id);
		
		model.addAttribute("student", student);
		model.addAttribute("studentList", da.getStudents());
		
		//model.addAttribute("searchList", da.getSearchList()); <- if we want to search
		
		return "index";
	}
	
}
