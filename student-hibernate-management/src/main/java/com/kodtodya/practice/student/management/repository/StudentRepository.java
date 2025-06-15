package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentRepository {
   Student save(Student student);
   List<Student> findAll();
   Optional<Student> findById(int id);
   Student deleteById(int id);
   List<Student> findStudentWithPagination(int page, int size);
   Map<Integer, Student> findAllMap();
}
