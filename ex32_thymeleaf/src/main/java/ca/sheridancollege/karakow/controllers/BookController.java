package ca.sheridancollege.karakow.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancollege.karakow.beans.Book;

@Controller
public class BookController {
	
	List<Book> bookList = new CopyOnWriteArrayList<Book>();
	
	@GetMapping("/")
	public String goHome(Model model) {
		
		
		model.addAttribute("bookList", bookList);
		
		return "index.html";
	}
	
	@PostMapping("/addBook")
	public String addBook(Model model,
			@RequestParam String book_name,
			@RequestParam Long isbn,
			@RequestParam String author_name
			) {
		
		Book book = new Book(book_name, isbn, author_name);
		bookList.add(book);
		
		model.addAttribute("bookList", bookList);
		
		return "index.html";
	}

}
