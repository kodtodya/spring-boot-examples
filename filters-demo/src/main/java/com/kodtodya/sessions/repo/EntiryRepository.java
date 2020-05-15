package com.kodtodya.sessions.repo;

import com.kodtodya.sessions.beans.Training;

import java.util.List;

public interface EntiryRepository {

        public boolean store(Training t) ;

        public List<Training> retrieve()throws Exception;

        public Training search(int id) throws Exception;

        public boolean delete(int id) throws Exception;
}
