package com.example.JPA_2601.service;

import com.example.JPA_2601.dto.MessageDTO;
import com.example.JPA_2601.dto.SaleDTO;
import com.example.JPA_2601.entity.Sale;
import com.example.JPA_2601.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService implements ICrudService<SaleDTO, Integer>{
    @Autowired
    ISaleRepository iSaleRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public SaleDTO saveEntity(SaleDTO personDTO) {
        var entity = mapper.map(personDTO, Sale.class);
        return mapper.map(iSaleRepository.save(entity), SaleDTO.class) ;
    }

    @Override
    public SaleDTO getEntityById(Integer integer) {
        Sale sale = iSaleRepository.findById(integer).orElseThrow(()-> new RuntimeException("No existe ese id"));
        return mapper.map(sale, SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getAllEntities() {
        List<SaleDTO> saleDTOList = iSaleRepository.findAll()
                .stream()
                .map(sale -> mapper.map(sale, SaleDTO.class))
                .collect(Collectors.toList());
        return saleDTOList;
    }

    @Override
    public MessageDTO deleteEntity(Integer integer) {
        if(saleExists(integer)){
            iSaleRepository.deleteById(integer);
            return MessageDTO.builder().message("Venta elminada").action("ELIMINADO EXITOSO").build();
        }
        else throw new RuntimeException("No se puedo eliminar");
    }

    public boolean saleExists(Integer codigo) {
        return iSaleRepository.existsById(codigo);
    }

}
