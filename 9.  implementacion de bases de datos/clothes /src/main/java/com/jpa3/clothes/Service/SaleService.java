package com.jpa3.clothes.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa3.clothes.DTO.MessageDTO;
import com.jpa3.clothes.DTO.POCResponseDTO;
import com.jpa3.clothes.DTO.SaleRequestDTO;
import com.jpa3.clothes.DTO.SaleResponseDTO;
import com.jpa3.clothes.Entity.PieceOfClothing;
import com.jpa3.clothes.Entity.Sale;
import com.jpa3.clothes.Entity.SalePOC;
import com.jpa3.clothes.Repository.IPOCRepository;
import com.jpa3.clothes.Repository.ISalePOCRepository;
import com.jpa3.clothes.Repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService implements ICrudService<SaleResponseDTO, SaleRequestDTO, MessageDTO> {

    @Autowired
    ISaleRepository saleRepository;
    @Autowired
    ISalePOCRepository salePOCRepository;
    @Autowired
    IPOCRepository pocRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public SaleResponseDTO getById(Integer id) {
        var entity = saleRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("no pude encontrar la venta");
        });
        return mapper.convertValue(entity, SaleResponseDTO.class);
    }

    @Override
    public List<SaleResponseDTO> getAll() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream().map(s -> mapper.convertValue(s, SaleResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SaleResponseDTO add(SaleRequestDTO dto) {

        Sale entity = mapper.convertValue(dto, Sale.class);
        List<PieceOfClothing> clothesToBeSaved = new ArrayList<>();

        Integer[] clothes = dto.getClothes();
        for (Integer clothingId : clothes) {
            PieceOfClothing clothing = pocRepository.findById(clothingId).orElseThrow(() -> {
                throw new RuntimeException("Codigo de prenda invalido");
            });
            //agrego todas las prendas a ser asociadas a la venta
            //si alguna de estas no se encuentra, no se guarda ninguna relacion
            clothesToBeSaved.add(clothing);
        }
        //si todas las prendas existen, se guardan las relaciones entre estas y la venta
        saleRepository.save(entity);

        for (PieceOfClothing clothing : clothesToBeSaved) {
            SalePOC salePOC = new SalePOC(null, entity, clothing);
            salePOCRepository.save(salePOC);
        }

        return mapper.convertValue(entity, SaleResponseDTO.class);
    }

    @Override
    public MessageDTO delete(Integer id) {
        var entity = saleRepository.findById(id).orElseThrow(() ->
        {
            throw new RuntimeException("No se encuentra dicha venta");
        });

        saleRepository.delete(entity);

        return MessageDTO.builder()
                .message("El id: " + id + " fue borrado con exito")
                .action("DELETED")
                .build();
    }

    @Override
    public SaleResponseDTO update(SaleRequestDTO dto) {
        //se eliminan las relaciones previas que tenga la venta con otras prendas
        deleteRelations(dto.getCode());
        //en el add se agregaran las nuevas relaciones, independientemente de que sean iguales a las previas
        return add(dto);
    }

    public List<SaleResponseDTO> findByDate(LocalDate date) {
        if (date == null) {
            return getAll();
        }

        var sales = saleRepository.getAllByDate(date);
        List<SaleResponseDTO> saleDTOs = new ArrayList<>();
        for (Sale sale : sales) {
            saleDTOs.add(mapper.convertValue(sale, SaleResponseDTO.class));
        }
        return saleDTOs;
    }

    public Boolean saleExists(Integer id) {
        return saleRepository.existsById(id);
    }


    public void deleteRelations(int saleCode) {
        List<SalePOC> relations = salePOCRepository.findAll().stream().filter(s -> s.getSale().getCode() == saleCode).collect(Collectors.toList());
        for (SalePOC relation : relations) {
            salePOCRepository.delete(relation);
        }
    }

    public List<POCResponseDTO> findClothesBySaleId(Integer id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() ->
        {
            throw new RuntimeException("No se encuentra dicha venta");
        });
        List<PieceOfClothing> clothing= new ArrayList<>();
        List<SalePOC> salePOCs=salePOCRepository.findAll().stream().filter(sp->sp.getSale().getCode()== id).collect(Collectors.toList());
        List<POCResponseDTO> response= new ArrayList<>();

        for(SalePOC salePOC : salePOCs){
            clothing.add(pocRepository.findById(salePOC.getClothing().getCode()).get());
        }

        for(PieceOfClothing poc : clothing){
            response.add(mapper.convertValue(poc, POCResponseDTO.class));
        }

        return response;
    }
}
