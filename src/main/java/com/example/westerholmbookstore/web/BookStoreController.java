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
        
        model.addAttribute("books", books);

       
        return "booklist";
        
    }
 
    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }
    
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
 
    }
    

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
