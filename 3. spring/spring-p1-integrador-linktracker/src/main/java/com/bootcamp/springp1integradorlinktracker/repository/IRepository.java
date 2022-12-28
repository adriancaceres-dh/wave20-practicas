package com.bootcamp.springp1integradorlinktracker.repository;

import com.bootcamp.springp1integradorlinktracker.model.Link;

import java.util.List;

public interface IRepository<T> {
    List<T> filterByUrl(String url);
    boolean contains(T t);
    boolean add(T t);
}
