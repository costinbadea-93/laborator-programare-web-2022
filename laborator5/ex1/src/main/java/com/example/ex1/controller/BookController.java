package com.example.ex1.controller;


import com.example.ex1.model.Book;
import com.example.ex1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    public  BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return bookService.findAll();
    }

    @PostMapping("/books/new")
    public ResponseEntity<List<Book>> newBook(@RequestBody Book book){
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/books/{id}")
                .buildAndExpand(book.getBookId())
                .toUri();

        return ResponseEntity.created(location).body(bookService.addBook(book));
    }

    @DeleteMapping("/books/remove/{bookId}")
    public List<Book> deleteBook(@PathVariable int bookId) {
        return bookService.deleteBook(bookId);
    }

    @GetMapping("/books/bookById")
    public ResponseEntity<?> retrieveById(@RequestParam int bookId){
        try{
            return ResponseEntity.accepted().body(bookService.findById(bookId));
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
