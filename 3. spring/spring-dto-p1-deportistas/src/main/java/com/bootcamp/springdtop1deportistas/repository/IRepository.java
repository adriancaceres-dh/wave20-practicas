package com.bootcamp.springdtop1deportistas.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> filterByName(String name);
    boolean contains(T t);
    boolean add(T t);
}
