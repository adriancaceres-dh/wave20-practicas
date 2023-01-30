package com.jpa3.clothes.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa3.clothes.DTO.MessageDTO;
import com.jpa3.clothes.DTO.POCResponseDTO;
import com.jpa3.clothes.Entity.PieceOfClothing;
import com.jpa3.clothes.Entity.Sale;
import com.jpa3.clothes.Entity.SalePOC;
import com.jpa3.clothes.Repository.IPOCRepository;
import com.jpa3.clothes.Repository.ISalePOCRepository;
import com.jpa3.clothes.Repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PieceOfClothingService implements ICrudService<POCResponseDTO, PieceOfClothing, MessageDTO> {

    @Autowired
    IPOCRepository pocRepository;
    @Autowired
    ISalePOCRepository salePOCRepository;
    @Autowired
    ISaleRepository saleRepository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public POCResponseDTO getById(Integer id) {
        var entity = pocRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("no pude encontrar la prenda");
        });
        return mapper.convertValue(entity, POCResponseDTO.class);
    }

    @Override
    public List<POCResponseDTO> getAll() {

        List<PieceOfClothing> clothing = pocRepository.findAll();
        return clothing.stream().map(c -> mapper.convertValue(c, POCResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public POCResponseDTO add(PieceOfClothing entity) {

        PieceOfClothing clothing = pocRepository.save(entity);
        return mapper.convertValue(clothing, POCResponseDTO.class);
    }

    @Override
    public MessageDTO delete(Integer id) {

        var entity = pocRepository.findById(id).orElseThrow(() ->
        {
            throw new RuntimeException("No se encuentra dicha prenda");
        });
        //relaciones
        var relationsToDelete = salePOCRepository.findAll().stream().filter(s -> Objects.equals(s.getClothing().getCode(), id)).collect(Collectors.toList());
        //ventas
        var salesToDelete= saleRepository.findAll().stream().filter(s->s.getSalePOCs()
                                                                    .stream().anyMatch(sp-> Objects.equals(sp.getClothing().getCode(), id)))
                                                                    .collect(Collectors.toList());
        //Elimina prenda
        pocRepository.delete(entity);

        //Elimina las relaciones con ventas
        for (SalePOC relation : relationsToDelete) {
            salePOCRepository.delete(relation);
        }

        //Elimina las ventas en las que se encontrase
        for(Sale sale : salesToDelete){
            saleRepository.delete(sale);
        }

        //return
        return MessageDTO.builder()
                .message("El id: " + id + " fue borrado con exito")
                .action("DELETED")
                .build();
    }

    @Override
    public POCResponseDTO update(PieceOfClothing dto) {
        return add(dto);
    }

    public Boolean POCExists(Integer id) {
        return pocRepository.existsById(id);
    }

    public List<PieceOfClothing> findBySize(String size) {
        var list = pocRepository.findBySizeEquals(size);
        return list; //devolver dtos
    }

    public List<PieceOfClothing> findByName(String name) {
        var list = pocRepository.findByNameContains(name);
        return list;
    }
}
