package com.example.westerholmbookstore.domain;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface bookstorereposity extends CrudRepository<Book, Long> {
    
	List<Book> findByTitle(String title);
}
