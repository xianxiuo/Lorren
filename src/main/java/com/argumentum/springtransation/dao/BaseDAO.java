package com.argumentum.springtransation.dao;

import java.util.List;

public interface BaseDAO<T> {

    T merge(T entity);

    void remove(T entity);

    T find(long id);

    List<T> findAll();
    
    void execute(String sql);

}
