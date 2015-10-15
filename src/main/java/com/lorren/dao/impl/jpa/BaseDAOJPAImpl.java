package com.lorren.dao.impl.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.lorren.dao.BaseDAO;

@Transactional
public class BaseDAOJPAImpl<T> implements BaseDAO<T> {
    
    @SuppressWarnings("unchecked")
    private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager manager;

    public T merge(T entity) {
        return manager.merge(entity);
    }

    public void remove(T entity) {
        manager.remove(entity);
    }
    
    public void execute(String sql) {
        manager.createNativeQuery(sql);
    }

    @Transactional(readOnly = true)
    public T find(long id) {
        return manager.find(entityClass, id);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return manager.createNamedQuery("User.findAll", entityClass).getResultList();
    }

}
