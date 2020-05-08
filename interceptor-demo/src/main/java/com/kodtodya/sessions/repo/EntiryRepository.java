package com.kodtodya.sessions.repo;

import com.kodtodya.sessions.beans.Training;

import java.util.List;

public interface EntiryRepository {

        public boolean store(Training t);

        public List<Training> retrieve();

        public Training search(int id);

        public boolean delete(int id);
}
