package com.example.westerholmbookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.westerholmbookstore.domain.bookstorereposity;



import com.example.westerholmbookstore.domain.Book;
import com.example.westerholmbookstore.domain.Category;
import com.example.westerholmbookstore.domain.CategoryRepository;




@SpringBootApplication
public class WesterholmbookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(WesterholmbookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WesterholmbookstoreApplication.class, args);
	} 

	@Bean
	public CommandLineRunner demo(bookstorereposity repository, CategoryRepository crepository) {
	return (args) ->{
		crepository.save(new Category("History"));
		crepository.save(new Category("Humor"));
		crepository.save(new Category("Drama"));
		crepository.save(new Category("Action"));
		crepository.save(new Category("Sci-fi"));
		
		log.info("fetch all Books");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
		
		
		};
	}
} 

