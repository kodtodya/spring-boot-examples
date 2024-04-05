package com.kodtodya.practice.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EntityRepository<T> {
    T save(T object);

    List<T> findAll();

    Optional<T> findById(Long id);

    Optional<T> findByName(String name);

    Set<T> findByAttribute(String value);

    void deleteById(Long id);
}
