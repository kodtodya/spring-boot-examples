package com.kodtodya.practice.student.management.repository;

import com.kodtodya.practice.student.management.domain.StudentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDomain, Integer> {
}
