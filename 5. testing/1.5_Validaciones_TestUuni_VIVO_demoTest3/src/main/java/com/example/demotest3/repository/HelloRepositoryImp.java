package com.example.demotest3.repository;

import com.example.demotest3.entity.Repuesta;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImp implements IHelloRepository{

    @Override
    public Repuesta saludoRepository(String name) {
        return new Repuesta("Hola, como estas "+ name);
    }
}
