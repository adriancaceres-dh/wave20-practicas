package com.example.MapeoDeUnaClaveCompuesta.service;

import com.example.MapeoDeUnaClaveCompuesta.dto.CompraDTO;
import com.example.MapeoDeUnaClaveCompuesta.dto.MessagesDTO;
import com.example.MapeoDeUnaClaveCompuesta.entity.Compra;
import com.example.MapeoDeUnaClaveCompuesta.entity.CompraKey;
import com.example.MapeoDeUnaClaveCompuesta.repositroy.ICompraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImp implements ICompraService{
    @Autowired
    private ICompraRepository repo;

    private ModelMapper mapper;

    public MessagesDTO compraSeve(CompraDTO compraDto){
        CompraKey comprakey = new CompraKey();
        if(!repo.existsById(comprakey)){
            repo.save(mapper.map(compraDto, Compra.class));
            return new MessagesDTO("Se ha creado una nueva compra","CREATE");
        }else{
            throw new RuntimeException("el idclient y la fecha ya existen en el sistema");
        }
    }


}
