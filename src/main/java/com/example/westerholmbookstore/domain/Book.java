package com.example.westerholmbookstore.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Book {
  
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String title, author,  publicationYear,  isbn, price;

	    
	    // Tällä voidaan yhdistään category tiedostoon
	    @ManyToOne
	    @JoinColumn(name = "categoryId")
	    private Category category;


	    // Default constructor
	    public Book() {}


	    public Book(String title, String author, String publicationYear, String isbn, String price, Category category) {

	        this.title = title;
	        this.author = author;
	        this.publicationYear = publicationYear;
	        this.isbn = isbn;
	        this.price = price;

	        this.category = category;
	    }

		public Category getCategory() {
			return category;
		}

		@Override
		public String toString() {
			if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
					+ ", isbn=" + isbn + ", price=" + price + ", category=" + this.getCategory() + "]";
			else
				return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
						+ ", isbn=" + isbn + ", price=" + price + "]";
		}
	
			
		public void setCategory(Category category) {
			this.category = category;
		}


	    


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublicationYear() {
			return publicationYear;
		}

		public void setPublicationYear(String publicationYear) {
			this.publicationYear = publicationYear;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

	    // Getters and setters...
	}

	/*

	    public Book(String title, String author, String publicationYear, String isbn, String price) {^*/
	

	
	
	