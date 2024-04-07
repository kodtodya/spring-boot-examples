package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;

public record Author (int id, String firstName, String lastName) {

    private static List<Author> authors = Arrays.asList(
            new Author(1, "Joshua", "Bloch"),
            new Author(2, "Douglas", "Adams"),
            new Author(3, "Bill", "Bryson")
    );

    public static Author getById(int id) {
        return authors.stream()
				.filter(author -> author.id() == id)
				.findFirst()
				.orElse(null);
    }
}