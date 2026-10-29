package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }


    public List<Book> getBooks(){
        return repository.findAll();
    }
    public Optional<Book> getBookByID(Long id){
        try{
            return repository.findById(id);
        }catch (Exception e){
            throw new RuntimeException("Поиск элемента провалился");
        }

    }
    public void addBook(Book book){
        System.out.println("201 Created");
        repository.save(book);
    }
    public void updateBook(Long id, Book updatedBook){
        repository.deleteById(id);
        repository.save(updatedBook);
    }
    public void deleteBook(Long id){
        System.out.println("204 No Content");
        repository.deleteById(id);
    }
}
