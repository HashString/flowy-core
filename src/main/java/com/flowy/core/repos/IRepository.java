package com.flowy.core.repos;

/**
 * Created by ssinghal
 * Created on 03-Jun-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
public interface IRepository<T, ID> {

    public T saveOrUpdate(T entity);
    public T findOne(ID primaryKey);
    public Iterable<T> findAll();
    public void delete(T entity);
    public boolean exists(ID primaryKey);
}
