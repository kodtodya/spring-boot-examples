package com.kodtodya.practice.data.masking.repository;

import java.util.List;

import com.kodtodya.practice.data.masking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByFirstName(String firstName);
}
