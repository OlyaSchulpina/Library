package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByAuthor(String author);
    @Query("select b from books b where b.author=:author and b.year=:year")
    Book findByAuthorAndYear(@Param("author") String author, @Param("year") int year);
    @Query(value="select * from books where author= :author", nativeQuery = true)
    Book findByAuthorNative(String author);

}
