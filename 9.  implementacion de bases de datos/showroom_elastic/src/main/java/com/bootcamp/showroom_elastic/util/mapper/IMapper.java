package com.bootcamp.showroom_elastic.util.mapper;

public interface IMapper<E, D> {
    E fromDTO(D dto);
    D toDTO(E entity);
}
