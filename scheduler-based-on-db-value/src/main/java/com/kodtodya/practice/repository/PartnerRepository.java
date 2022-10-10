package com.kodtodya.practice.repository;

import com.kodtodya.practice.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

  List<Partner> findByName(String firstName);
  Optional<Partner> findSchedulerByName(String name);
}