package ca.sheridancollege.karakow.beans;

import org.springframework.stereotype.Component;

@Component
public class Triangle extends Shape {
	
	public void draw() {
		System.out.println("Triangle");
		}
}
