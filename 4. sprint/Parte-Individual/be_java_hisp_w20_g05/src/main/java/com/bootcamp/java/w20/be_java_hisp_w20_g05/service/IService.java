package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import java.util.List;

public interface IService<T> {
    List<T> filterBy(String name);
}
