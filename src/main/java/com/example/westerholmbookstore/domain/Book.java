package com.example.westerholmbookstore.domain;

<<<<<<< HEAD

=======
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
=======
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62

@Entity
public class Book {
  
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String title, author,  publicationYear,  isbn, price;
<<<<<<< HEAD
	    
	    // Tällä voidaan yhdistään deparment tiedostoon
	    @ManyToOne
	    @JoinColumn(name = "categoryid")
	    private Category category;
=======
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62

	    // Default constructor
	    public Book() {}

<<<<<<< HEAD
	    public Book(String title, String author, String publicationYear, String isbn, String price, Category category) {
=======
	    public Book(String title, String author, String publicationYear, String isbn, String price) {
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62
	        this.title = title;
	        this.author = author;
	        this.publicationYear = publicationYear;
	        this.isbn = isbn;
	        this.price = price;
<<<<<<< HEAD
	        this.category = category;
	    }

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

=======
	    }

>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62
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

	
	

	
	
	