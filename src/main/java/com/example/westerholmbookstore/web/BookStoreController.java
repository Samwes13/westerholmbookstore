package com.example.westerholmbookstore.web;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.westerholmbookstore.domain.bookstorereposity;
import com.example.westerholmbookstore.domain.Book;

@Controller
public class BookStoreController {
	
	@Autowired
	private bookstorereposity repository;
	

    @GetMapping("/booklist")
    public String booklist(Model model) {
    	Iterable<Book> books = repository.findAll();
        // Add the list of books to the model
        model.addAttribute("books", books);

        // Return the name of the HTML template to be rendered
        return "booklist";
        
    }
 // New method to display add book form
    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    // New method to handle adding a book
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }
    
    // New method to handle deleting a book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
 
    }
    
 // New method to display edit book form
    @GetMapping("/editbook/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            
            return "editbook";
        } else {
        	
            return "redirect:/booklist";
        }
    }
    
    // New method to handle saving edited book
    @PostMapping("/editbook/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute Book editedBook) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(editedBook.getTitle());
            book.setAuthor(editedBook.getAuthor());
            book.setPublicationYear(editedBook.getPublicationYear());
            book.setIsbn(editedBook.getIsbn());
            book.setPrice(editedBook.getPrice());
            repository.save(book);
        }
        return "redirect:/booklist";
    }


}