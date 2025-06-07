package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.model.Clazz;

import java.util.Optional;
import java.util.Set;

public interface ClazzRepository {
   Clazz save(Clazz clazz);
   Set<Clazz> findAll();
   Optional<Clazz> findById(int id);
   Clazz deleteById(int id);
   Set<Clazz> findClazzWithPagination(int page, int size);
}
