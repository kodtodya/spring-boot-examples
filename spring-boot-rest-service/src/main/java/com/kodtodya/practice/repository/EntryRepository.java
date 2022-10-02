package com.kodtodya.practice.repository;

import com.kodtodya.practice.domain.Training;

import java.util.List;

public interface EntryRepository {

        public String store(Training training);

        public List<Training> retrieve();

        public String search(int id);

        public String delete(int id);

        public String update(Training training);
}