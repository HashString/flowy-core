package com.flowy.core.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ssinghal
 * Created on 03-Jun-2014
 * If you refactor this code, remember: Code so clean you could eat off it!
 */
@Repository
public class BaseRepository<T, ID extends Serializable> implements IRepository<T, ID> {

    @Autowired
    MongoOperations mongoOperations;

    public BaseRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public T saveOrUpdate(T entity) {
        mongoOperations.save(entity);
        return entity;
    }

    @Override
    public T findOne(ID primaryKey) {
        return null;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public boolean exists(ID primaryKey) {
        return false;
    }
}
