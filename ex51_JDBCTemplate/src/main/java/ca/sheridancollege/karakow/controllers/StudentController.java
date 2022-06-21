package ca.sheridancollege.karakow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.karakow.beans.Province;
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
		model.addAttribute("provinceList", da.getProvinces());
		
		return ("index");
	}
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model,
			@RequestParam String name,
			@RequestParam Long houseNumber,
			@RequestParam String streetName,
			@RequestParam String city,
			@RequestParam String province,
			@ModelAttribute Student student,
			@ModelAttribute Province provinces) {
		

		model.addAttribute("student", new Student());
		model.addAttribute("studentList", da.getStudents());
		model.addAttribute("province", province);
		model.addAttribute("provinceList", da.getProvinces());
		
		da.insertStudent(name, houseNumber, streetName, city, province);
		
		return ("index");
	}
	
}
