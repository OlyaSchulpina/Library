package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService service;
    public BookController(BookService service) {
        this.service = service;
    }
    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getBooks();
    }
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        return service.getBookByID(id);
    }
    @PostMapping("/books/addBook")
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book book){
        service.updateBook(id,book);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable int id){
        service.deleteBook(id);
    }
}
