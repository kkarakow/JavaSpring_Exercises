package ca.sheridancollege.karakow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.karakow.beans.Shape;

@Controller
public class HomeController {

	//@Autowired // reflection based injection - not ideal one
	Shape s;
	
	//@Autowired // setter based injection
	public void setShape(Shape s) {
		this.s = s;
	}
	
	//highly disarible injestion - best one!
	//constructor based injection
	@Autowired
	public HomeController(Shape s) {
		this.s = s;
	}
	
	@GetMapping("/")
	public String goHome() {
		s.draw();
		return "index";
	}
	
	
}
