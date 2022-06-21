package ca.sheridancollege.karakow.beans;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable{

	private String book_name;
	private Long isbn;
	private String author_name;
	
}
