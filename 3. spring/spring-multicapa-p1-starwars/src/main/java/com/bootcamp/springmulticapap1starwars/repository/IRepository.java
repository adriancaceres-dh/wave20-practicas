package com.bootcamp.springmulticapap1starwars.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> filterBy(String name);
    boolean add(T t);
}
