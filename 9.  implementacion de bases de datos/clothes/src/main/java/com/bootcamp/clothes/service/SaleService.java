package com.bootcamp.clothes.service;

import com.bootcamp.clothes.dto.request.ClotheSaleListDTO;
import com.bootcamp.clothes.dto.request.SaleDTO;
import com.bootcamp.clothes.dto.response.MessageDTO;
import com.bootcamp.clothes.entity.ClotheSale;
import com.bootcamp.clothes.entity.Customer;
import com.bootcamp.clothes.entity.Sale;
import com.bootcamp.clothes.repository.IClotheRepository;
import com.bootcamp.clothes.repository.ICustomerRepository;
import com.bootcamp.clothes.repository.ISaleRepository;
import com.bootcamp.clothes.service.interfaces.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IClotheRepository clotheRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public MessageDTO saveEntity(SaleDTO saleDTO) {
        Customer customer = customerRepository.findById(saleDTO.getIdCustomer())
                .orElseThrow(() -> new RuntimeException("customer with id " + saleDTO.getIdCustomer() + " not exist"));

        List<ClotheSaleListDTO> clotheSalesListDTO = saleDTO.getClotheSales();

        Sale sale = new Sale();
        sale.setNumber(saleDTO.getNumber());
        sale.setCustomer(customer);
        sale.setDate(saleDTO.getDate());
        sale.setTotal(saleDTO.getTotal());
        sale.setMeansPayment(saleDTO.getMeansPayment());
        sale.setClotheSales(clotheSalesListDTO.stream().map(
                clotheSaleDTO -> new ClotheSale(null, clotheRepository.findById(clotheSaleDTO.getCodeClothe())
                        .orElseThrow(() -> new RuntimeException("clothe with id " + clotheSaleDTO.getCodeClothe() +
                                " not exist")), sale, clotheSaleDTO.getQuantity())
        ).collect(Collectors.toList()));

        saleRepository.save(sale);
        //saveSale(sale, saleDTO);
        return MessageDTO.builder()
                .action("CREATE")
                .message("Sale has been successfully saved")
                .build();
    }

    @Override
    public SaleDTO getEntityById(Integer number) {
        Sale sale = saleRepository.findById(number)
                .orElseThrow(() -> new RuntimeException("sale with number " + number + " not exist"));
        return mapper.map(sale, SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getAllEntities() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream().map(sale -> mapper.map(sale, SaleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO updateEntity(Integer number, SaleDTO saleDTO) {
        Sale sale = saleRepository.findById(number)
                .orElseThrow(() -> new RuntimeException("sale with number " + number + " not exist"));
        if (!sale.getCustomer().getId().equals(saleDTO.getIdCustomer()))
            throw new RuntimeException("Customer id does not match");
        sale.setNumber(number);
        sale.setCustomer(sale.getCustomer());
        sale.setDate(saleDTO.getDate());
        sale.setTotal(saleDTO.getTotal());
        sale.setMeansPayment(saleDTO.getMeansPayment());
        List<ClotheSaleListDTO> clotheSaleList = saleDTO.getClotheSales();
        //sale.setClotheSales(null);
        //saleRepository.save(sale).setClotheSales(null);
        sale.setClotheSales(clotheSaleList.stream()
                .map(clotheSaleDTO -> new ClotheSale(null, clotheRepository.findById(clotheSaleDTO.getCodeClothe())
                        .orElseThrow(() -> new RuntimeException("clothe with id " + clotheSaleDTO.getCodeClothe() +
                                " not exist")), sale, clotheSaleDTO.getQuantity())
                ).collect(Collectors.toList()));
        saleRepository.save(sale);
        //if (saveSale(sale, saleDTO))
        return MessageDTO.builder()
                .action("UPDATE")
                .message("The sale has been successfully modified")
                .build();

    }

    @Override
    public MessageDTO deleteEntity(Integer number) {
        Sale sale = saleRepository.findById(number)
                .orElseThrow(() -> new RuntimeException("sale with number " + number + " not exist"));
        saleRepository.delete(sale);
        return MessageDTO.builder()
                .action("DELETE")
                .message("sale successfully eliminated")
                .build();
    }

    public List<SaleDTO> getAllSaleByDate(LocalDate date) {
        List<Sale> sales = saleRepository.findAllByDate(date);
        return sales.stream().map(sale -> mapper.map(sale, SaleDTO.class)).collect(Collectors.toList());
    }


    /*private boolean saveSale(Sale sale, SaleDTO saleDTO) {
        List<ClotheSaleListDTO> clotheSalesListDTO = saleDTO.getClotheSales();
        for (ClotheSaleListDTO clotheSales : clotheSalesListDTO)
            System.out.println("clotheSales = " + clotheSales);

        sale.setDate(saleDTO.getDate());
        sale.setTotal(saleDTO.getTotal());
        sale.setMeansPayment(saleDTO.getMeansPayment());
        sale.setClotheSales(clotheSalesListDTO.stream().map(
                clotheSaleDTO -> new ClotheSale(null, clotheRepository.findById(clotheSaleDTO.getCodeClothe())
                        .orElseThrow(() -> new RuntimeException("clothe with id " + clotheSaleDTO.getCodeClothe() +
                                " not exist")), sale, clotheSaleDTO.getQuantity())
        ).collect(Collectors.toList()));

        saleRepository.save(sale);
        return true;
    }*/
}
