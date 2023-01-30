package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public Joya create(Joya joya) {
        joya.setNro_identificatorio(null);
        joya.setVentaONo(true);


        var res=  joyaRepository.save(joya);
        return (Joya) res;
    }

    public Joya edit(Joya joya) {
        var repeated = joyaRepository.findById(joya.getNro_identificatorio());
        if(repeated.isEmpty()){
            throw new RuntimeException("No se encontro la joya para eliminar");
        }

        var res=  joyaRepository.save(joya);
        return (Joya) res;
    }
    @Override
    public List<Joya> getAll() {
        List<Joya> joyas= joyaRepository.findAll();
        joyas = joyas.stream().filter(x->x.getVentaONo() == true).collect(Collectors.toList());
        return joyas;
        }

    @Override
    public Joya get(int id) throws Throwable {

        if(joyaRepository.findById(id).isPresent()){
            return (Joya) joyaRepository.findById(id).get();
        }else{
            throw new RuntimeException("No se encontro la joya a buscar");
        }
    }

    @Override
    public int delete(int id) {
        Joya joya= joyaRepository.findById(id).get();

        joyaRepository.delete(joya);
        return 1;
    }
}
