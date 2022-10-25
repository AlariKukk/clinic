package com.clinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    //T is a type and ID is an id
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteBy(T object);
}
