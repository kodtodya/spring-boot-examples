package com.kodtodya.practice.repository;

import com.kodtodya.practice.domain.Training;

import java.util.List;

public interface EntiryRepository {

    boolean store(Training t);

    List<Training> retrieve() throws Exception;

    Training search(int id) throws Exception;

    boolean delete(int id) throws Exception;
}
