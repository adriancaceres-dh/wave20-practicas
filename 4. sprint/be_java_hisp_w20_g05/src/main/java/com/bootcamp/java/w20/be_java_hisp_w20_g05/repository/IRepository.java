package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import java.util.List;

public interface IRepository<T> {
    boolean contains(T t);
    boolean add(T t);
    List<T> filterBy(String name);
}
