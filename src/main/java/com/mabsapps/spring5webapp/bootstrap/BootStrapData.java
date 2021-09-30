package com.mabsapps.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mabsapps.spring5webapp.domain.Author;
import com.mabsapps.spring5webapp.domain.Book;
import com.mabsapps.spring5webapp.domain.Publisher;
import com.mabsapps.spring5webapp.repositories.AuthorRepository;
import com.mabsapps.spring5webapp.repositories.BookRepository;
import com.mabsapps.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository pubRepo;

	/**
	 * @param authorRepository
	 * @param bookRepository
	 */
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository pubRepo) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.pubRepo = pubRepo;
	}

	@Override
	public void run(String... args) throws Exception {

		Author eric = new Author("Eric", "Evans");
		Book some = new Book("DDD", "1234");

		eric.getBooks().add(some);
		some.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(some);

		Author rod = new Author("Rod", "Johnson");
		Book jee = new Book("JEE without EJB", "5678");

		rod.getBooks().add(jee);
		jee.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(jee);

		System.out.println("BootStrapping Started ...");
		System.out.println("Total Books: " + bookRepository.count());

		Publisher hira = new Publisher("Hira Publishers", "Korangi", "Karachi", "Pakistan", "75260");
		pubRepo.save(hira);
		System.out.println("Publishers Included: \n\t" + hira.toString());

	}

}
