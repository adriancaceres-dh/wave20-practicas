package com.bootcamp.clothes_relational.service.sale;

import com.bootcamp.clothes_relational.dto.common.GarmentDTO;
import com.bootcamp.clothes_relational.dto.common.SaleDTO;
import com.bootcamp.clothes_relational.dto.response.MessageDTO;
import com.bootcamp.clothes_relational.model.Garment;
import com.bootcamp.clothes_relational.model.Sale;
import com.bootcamp.clothes_relational.repository.IGarmentRepository;
import com.bootcamp.clothes_relational.repository.ISaleRepository;
import com.bootcamp.clothes_relational.utils.SaleUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements ISaleService {

    private final IGarmentRepository garmentRepository;
    private final ISaleRepository saleRepository;
    ModelMapper modelMapper = new ModelMapper();

    public SaleServiceImpl(IGarmentRepository garmentRepository, ISaleRepository saleRepository) {
        this.garmentRepository = garmentRepository;
        this.saleRepository = saleRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO create(SaleDTO saleDTO) {
        if(saleDTO.getNumber() != null)
            throw new RuntimeException("Sending the sale number when creating a sale is forbidden.");

        if(saleDTO.getTotal() != null)
            throw new RuntimeException("Sending the total when creating a sale is forbidden, it is calculated by the system.");

        Sale newSale = modelMapper.map(saleDTO, Sale.class);

        // Check if products exist
        for(Garment garment : newSale.getClothes()) {
            if(!garmentRepository.exists(Example.of(garment)))
                throw new RuntimeException("All clothes must match the available products.");
        }

        // Update the total
        newSale.setTotal(SaleUtils.getSaleTotal(newSale.getClothes()));

        newSale = saleRepository.save(newSale);

        return new MessageDTO(201, "Created", "The sale was created with the following number: " + newSale.getNumber() + ".");
    }

    @Override
    public List<SaleDTO> getAll() {
        List<Sale> sales = saleRepository.findAll();

        return sales.stream().map(sale -> modelMapper.map(sale, SaleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SaleDTO getById(Long id) {
        Sale found = saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));

        return modelMapper.map(found, SaleDTO.class);
    }

    @Override
    public MessageDTO update(Long id, SaleDTO saleDTO) {
        if(!id.equals(saleDTO.getNumber()))
            throw new RuntimeException("The endpoint sale number must match the payload sale number.");

        if(!saleRepository.existsById(id))
            throw new RuntimeException("Sale not found.");

        if(saleDTO.getTotal() != null)
            throw new RuntimeException("Sending the total when updating a sale is forbidden, it is calculated by the system.");

        Sale updated = modelMapper.map(saleDTO, Sale.class);

        // Check if products exist
        for(Garment garment : updated.getClothes()) {
            if(!garmentRepository.exists(Example.of(garment)))
                throw new RuntimeException("All clothes must match the available products.");
        }

        // Update the total
        updated.setTotal(SaleUtils.getSaleTotal(updated.getClothes()));

        saleRepository.save(updated);

        return new MessageDTO(200, "Updated", "The sale was updated.");
    }

    @Override
    public MessageDTO deleteById(Long id) {
        if(!saleRepository.existsById(id))
            throw new RuntimeException("Sale not found.");

        saleRepository.deleteById(id);

        return new MessageDTO(200, "Deleted", "The sale was deleted.");
    }

    @Override
    public List<SaleDTO> getAllByDateEquals(LocalDate date) {
        List<Sale> sales = saleRepository.findAllByDateEquals(date);

        return sales.stream().map(sale -> modelMapper.map(sale, SaleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<GarmentDTO> getClothesBySaleNumber(Long number) {
        if(!saleRepository.existsById(number))
            throw new RuntimeException("Sale not found.");

        List<Garment> clothes = saleRepository.findClothesBySaleNumber(number);

        return clothes.stream().map(garment -> modelMapper.map(garment, GarmentDTO.class)).collect(Collectors.toList());
    }
}
