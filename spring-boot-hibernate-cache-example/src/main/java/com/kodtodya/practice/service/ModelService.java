package com.kodtodya.practice.service;

import java.util.List;
import java.util.Set;

public interface ModelService<M,D> {

    M save(M m);
    boolean delete(final Long id);
    List<M> getAllRecords();
    M getRecordById(final Long id);
    Set<M> getRecordByAttribute(String attribute);
    M toModel(D d);
    D toEntity(M m);
}
