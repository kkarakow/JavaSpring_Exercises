package ca.sheridancollege.karakow.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Serializable{
	
	private Long id;
	private String model;
	private double price;
	
	
}
