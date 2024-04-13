package com.kodtodya.practice.graphql.service;

import com.kodtodya.practice.graphql.model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private final List<Author> authors = new ArrayList<>();

    public AuthorService() {
        authors.add(new Author(1, "Joshua", "Bloch"));
        authors.add(new Author(2, "Douglas", "Adams"));
        authors.add(new Author(3, "Bill", "Bryson"));
    }

    public Author getById(int id) {
        return authors.stream()
                .filter(author -> author.id() == id)
                .findFirst()
                .orElse(null);
    }
}
