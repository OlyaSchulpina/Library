package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService service;
    private String test;
    private String login;
    public BookController(BookService service, @Value("${spring.login}") String login, @Value("${security.data}") String test){
        this.service = service;
        this.test = test;
        this.login = login;
    }
    @GetMapping("/test")
    public void test(){
        System.out.println(test+login);
    }
    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getBooks();
    }
    @GetMapping("/books/{id}")
    public Optional<Book> getBook(@PathVariable Long id){
        return service.getBookByID(id);
    }
    @PostMapping("/books/addBook")
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book book){
        service.updateBook(id,book);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBook(id);
    }
}
