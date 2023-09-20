package com.example.westerholmbookstore.web;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.westerholmbookstore.domain.bookstorereposity;


import com.example.westerholmbookstore.domain.Book;
import com.example.westerholmbookstore.domain.Category;
import com.example.westerholmbookstore.domain.CategoryRepository;
=======

import com.example.westerholmbookstore.domain.bookstorereposity;
import com.example.westerholmbookstore.domain.Book;
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62

@Controller
public class BookStoreController {
	
	@Autowired
	private bookstorereposity repository;
	
<<<<<<< HEAD
	@Autowired
	private CategoryRepository crepository;
	
=======
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62

    @GetMapping("/booklist")
    public String booklist(Model model) {
    	Iterable<Book> books = repository.findAll();
        
        model.addAttribute("books", books);

<<<<<<< HEAD
        
=======
       
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62
        return "booklist";
        
    }
 
    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
<<<<<<< HEAD
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
    

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book, @RequestParam("categoryid") Long categoryId){
        Optional<Category> category = crepository.findById(categoryId);
        
        if(category.isPresent()){
            book.setCategory(category.get());
            repository.save(book);
        }
        
        return "redirect:booklist";
    }



    

=======
        return "addbook";
    }
    
    
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62
    
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
 
    }
    
<<<<<<< HEAD
    @RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            model.addAttribute("categories", crepository.findAll());
            return "editbook";
        } else {
            return "redirect:/booklist";
        }
    } 

    



}
=======

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
>>>>>>> 118673c21236a5a3e4a6d8c8dd8f5d145656de62
