package ca.sheridancollege.karakow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/") 
	public String index() {
		return "index";
	}
	
	@GetMapping("/hairColour") 
	public String hairColour() {
		return "hairColour";
	}
	
	@GetMapping("/someText") 
	public String someText() {
		return "someText";
	}
	
	@GetMapping("/preferedName") 
	public String preferedName() {
		return "preferedName";
	}
	
}
