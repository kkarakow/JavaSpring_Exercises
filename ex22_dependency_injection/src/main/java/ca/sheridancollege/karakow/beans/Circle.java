package ca.sheridancollege.karakow.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Circle extends Shape{

	@Override
	public void draw() {
		System.out.println("Circle");
	}
}
