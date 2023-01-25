package com.implementacion_bd.Joyeria.Service;

import com.implementacion_bd.Joyeria.Entities.Joya;
import com.implementacion_bd.Joyeria.Repository.IJoyeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaService implements ICRUDService<Joya> {

    @Autowired
    IJoyeriaRepository repository;

    @Override
    public List<Joya> findAll() {
        return repository.findAll();
    }

    @Override
    public Joya findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Joya create(Joya requestDto) {
        return repository.save(requestDto);
    }

    @Override
    public Joya update(Joya requestDto) {
        return repository.save(requestDto);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(findById(id));
    }
}
