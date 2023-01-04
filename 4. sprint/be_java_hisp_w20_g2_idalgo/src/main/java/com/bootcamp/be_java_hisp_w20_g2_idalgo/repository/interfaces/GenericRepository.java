package com.bootcamp.be_java_hisp_w20_g2_idalgo.repository.interfaces;

public interface GenericRepository<T, ID> {
    T save(T entity);

    T findOne(ID key);

    boolean exists(ID key);
}
