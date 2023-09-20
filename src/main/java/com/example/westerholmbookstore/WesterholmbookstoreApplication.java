package com.example.westerholmbookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.westerholmbookstore.domain.bookstorereposity;
<<<<<<< HEAD


import com.example.westerholmbookstore.domain.Book;
import com.example.westerholmbookstore.domain.Category;
import com.example.westerholmbookstore.domain.CategoryRepository;
=======
import com.example.westerholmbookstore.domain.Book;
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62


@SpringBootApplication
public class WesterholmbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WesterholmbookstoreApplication.class, args);
	} 

	@Bean
<<<<<<< HEAD
	public CommandLineRunner demo(bookstorereposity repository, CategoryRepository crepository) {
	return (args) -> {
		crepository.save(new Category("History"));
		crepository.save(new Category("Humor"));
		crepository.save(new Category("Drama"));
		crepository.save(new Category("Action"));
		crepository.save(new Category("Sci-fi"));
	};
	

	
=======
	public CommandLineRunner demo(bookstorereposity repository) {
	return (args) -> {
	// Your code...add some demo data to db
		
	};

>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62

	} 
}
