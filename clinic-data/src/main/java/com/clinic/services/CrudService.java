package com.clinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    //T is a type and ID is an id
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void deleteById(ID id);

    void delete(T object);
}
//this Service helps against duplicating the code