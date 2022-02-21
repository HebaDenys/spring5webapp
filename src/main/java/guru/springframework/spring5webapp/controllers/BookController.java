package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;
//	Un controller sembra essere una classe che serve a dare indicazioni sui request mapping
//	e cosa ogni mapping deve chiamare e restituire, in questo caso il request map/path
//	che abbiamo mappato è il /books quindi verrà chiamto il metodo getBooks quando viene
//	fatta una chiamata dal broweser o una chiamata REST al path localhost:8080/books
//	(la porta e l'host name sono quelli predefiniti in questo caso)
@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}




	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());

		// questo è il path per il file HTML da risolvere e parte da src/main/resources/templates
		return "books/list";
	}

}
