package com.example.westerholmbookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {

     List<Category> findByName(String name);

}
