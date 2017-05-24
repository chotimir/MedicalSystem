package com.medicalsystem.service;

import java.util.List;

public interface CRUDService<T> {
    List<T> listAll();

    T getById(Integer id);

    T saveOrUpdate(T t);

    void delete(Integer id);
}
