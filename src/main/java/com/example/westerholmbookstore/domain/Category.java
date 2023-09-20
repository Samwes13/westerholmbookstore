package com.example.westerholmbookstore.domain;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String nameOfCategory;
	
	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getNameOfCategory() {
		return nameOfCategory;
	}

	public void setNameOfCategory(String nameOfCategory) {
		this.nameOfCategory = nameOfCategory;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {}
	
	public Category(String nameOfCategory) {
		super();
		this.nameOfCategory = nameOfCategory;
	}
	

}
