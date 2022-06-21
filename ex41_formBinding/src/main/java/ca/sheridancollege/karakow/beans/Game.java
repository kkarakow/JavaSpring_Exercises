package ca.sheridancollege.karakow.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game implements Serializable{
	
	private Long id;
	private String title;
	private String publisher;
	private String platform;
	private final String[] platforms = 
		{"PS4", "PS5", "Xbox 360", "Xbox one", "Nintendo"};
	private double price;

}
