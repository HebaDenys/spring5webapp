package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository , PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Author eric = new Author("Eric","Evans");
		Author rod = new Author("Rod","Jhonson");
		
		Book ddd = new Book("Domain Driven Desing","123123");
		Book noEJB = new Book("J2EE Development","521456666");
		Publisher denys = new Publisher( "Denys", "via di vittorio", "San Donato", "Italia", "20097");
		
			
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);

		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		noEJB.setPublisher(denys);
		denys.getBooks().add(noEJB);
		publisherRepository.save(denys);
		
		ddd.setPublisher(denys);
		denys.getBooks().add(ddd);
		
		publisherRepository.save(denys);
		
		
		
		System.out.println("Strted in BootStrap");
		System.out.println("Number of books : " + bookRepository.count());
		
		
	
		
		System.out.println("Number of publishers : " + publisherRepository.count());
		System.out.println("Publishers number of books: " + denys.getBooks().size());
		
		
	}
	

}
