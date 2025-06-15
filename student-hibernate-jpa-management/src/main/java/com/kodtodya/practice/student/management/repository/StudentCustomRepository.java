package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.domain.StudentDomain;

import java.util.List;

public interface StudentCustomRepository {
    List<StudentDomain> findByCriteria(double percentage);
}
