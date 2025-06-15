package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.domain.StudentDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDomain, Integer>, StudentCustomRepository {
}
