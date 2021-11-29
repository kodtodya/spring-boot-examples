package com.kodtodya.practice.repository;

import java.util.List;
import java.util.Optional;

import com.kodtodya.practice.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

  List<Partner> findByName(String firstName);
  Optional<Partner> findSchedulerByName(String name);
}
