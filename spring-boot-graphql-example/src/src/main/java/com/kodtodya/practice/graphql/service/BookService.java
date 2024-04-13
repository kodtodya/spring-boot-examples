package com.kodtodya.practice.graphql.service;

import com.kodtodya.practice.graphql.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1, "Effective Java", 416, 1));
        books.add(new Book(2, "Hitchhiker's Guide to the Galaxy", 208, 2));
        books.add(new Book(3, "Down Under", 436, 3));
    }

    public Book getById(int id) {
        return books.stream()
                .filter(book -> book.id() == id)
                .findFirst()
                .orElse(null);
    }

    public Book addBook(Book book) {
        books.add(book);
        System.out.println("Book added in book service");
        return book;
    }
}
