package ca.sheridancollege.karakow.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.karakow.beans.Appointment;



@Controller
public class HomeController {

	@GetMapping("/")
	public String getHome() {
		return "index.html";
	}
	

	@PostMapping("/formPost")
	public String formPost(@RequestParam String firstName,
			@RequestParam String email,
			@RequestParam("appointmentDate") 
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
	@RequestParam("appointmentTime") 
	@DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime appointmentTime
			) {
		
		Appointment appointment = new Appointment();
		appointment.setFirstName(firstName);
		appointment.setEmail(email);
		appointment.setAppointmentDate(appointmentDate);
		appointment.setAppointmentTime(appointmentTime);
		
		System.out.println(appointment);
		
		return "working.html";
	}
	
}

	

