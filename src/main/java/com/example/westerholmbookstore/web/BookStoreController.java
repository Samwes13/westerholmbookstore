package com.example.westerholmbookstore.web;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.westerholmbookstore.domain.bookstorereposity;


import com.example.westerholmbookstore.domain.Book;
import com.example.westerholmbookstore.domain.Category;
import com.example.westerholmbookstore.domain.CategoryRepository;

@Controller
public class BookStoreController {
	
	@Autowired
	private bookstorereposity repository;
	
	@Autowired
	private CategoryRepository crepository;
	

    @GetMapping("/booklist")
    public String booklist(Model model) {
    	Iterable<Book> books = repository.findAll();
        
        model.addAttribute("books", books);

        
        return "booklist";
        
    }
 
    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
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



    

    
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
 
    }
    
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