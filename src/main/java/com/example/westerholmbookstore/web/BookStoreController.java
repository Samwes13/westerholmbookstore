package com.example.westerholmbookstore.web;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.example.westerholmbookstore.domain.bookstorereposity;

import com.example.westerholmbookstore.domain.Book;
import com.example.westerholmbookstore.domain.Category;
import com.example.westerholmbookstore.domain.CategoryRepository;


import com.example.westerholmbookstore.domain.bookstorereposity;



@Controller
public class BookStoreController {
	
	@Autowired
	private bookstorereposity repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    } 
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
    	return repository.findById(bookId);
    }

	//Nayta kaikki kirjat
	@RequestMapping(value = "/booklist")
	public String bookList(Model model) {
	    List<Book> books = (List<Book>) repository.findAll();
	    model.addAttribute("books", books);
	    return "booklist";
	}
	
	
 ///////////////////////////////////////////////////////////////
	@RequestMapping(value = "/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
    

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Book book){
	    repository.save(book);
	    return "redirect:/booklist"; 
	}

    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    	Optional<Book> optionalBook = repository.findById(bookId);
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            model.addAttribute("categories", crepository.findAll());
            return "editbook";
        } else {
            
            return "redirect:/booklist";
        }
        }


 
    //POISTO
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
 
    }
    
    
    



}

