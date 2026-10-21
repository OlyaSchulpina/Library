package com.example.library.service;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();
    public List<Book> getBooks(){
        return books;
    }
    public Book getBookByID(int id){
        try{
            return books.get(id);
        }catch (Exception e){
            System.err.println("404 Not Found");
        }
        return null;
    }
    public void addBook(Book book){
        System.out.println("201 Created");
        books.add(book);
    }
    public void updateBook(int id, Book updatedBook){
        books.remove(books.get(id));
        books.add(updatedBook);
    }
    public void deleteBook(int id){
        System.out.println("204 No Content");
        books.remove(books.get(id));
    }
}
