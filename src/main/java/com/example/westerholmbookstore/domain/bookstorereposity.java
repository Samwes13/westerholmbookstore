package com.example.westerholmbookstore.domain;



import org.springframework.data.jpa.repository.JpaRepository;

public interface bookstorereposity extends JpaRepository<Book, Long> {
    // You can add custom query methods here if needed
}
