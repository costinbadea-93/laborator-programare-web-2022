package com.example.ex1.service;

import com.example.ex1.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private List<Book> bookList = new ArrayList<>();

    public List<Book> findAll() {
        logger.info("Retrieving from server {}", bookList);
        return bookList;
    }

    public List<Book> addBook(Book book) {
        logger.info("We added a new book: {}", book);
        bookList.add(book);
        return bookList;
    }

    public List<Book> deleteBook(int bookId) {
        logger.info("Removing from repository book with id {}", bookId);
        bookList = bookList.stream()
                .filter(book -> book.getBookId() != bookId)
                .toList();

        return bookList;
    }

    public Book findById(int bookId) {
        logger.info("Finding in repo book with id {}", bookId);
        return bookList.stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book for the given id cannot be found!"));
    }
}
