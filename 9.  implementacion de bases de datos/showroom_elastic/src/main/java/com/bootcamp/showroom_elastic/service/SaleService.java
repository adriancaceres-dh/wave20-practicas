package com.bootcamp.showroom_elastic.service;

import com.bootcamp.showroom_elastic.dto.SaleDTO;
import com.bootcamp.showroom_elastic.dto.SaleDTO;
import com.bootcamp.showroom_elastic.elastic_respositories.ElasticSaleRepository;
import com.bootcamp.showroom_elastic.util.mapper.ISaleMapper;
import com.bootcamp.showroom_elastic.util.mapper.implementation.SaleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SaleService {
    private final ElasticSaleRepository elasticSaleRepository;
    private final ISaleMapper saleMapper;

    public SaleDTO create(SaleDTO saleDTO) {
        var sale = saleMapper.fromDTO(saleDTO);
        sale = elasticSaleRepository.save(sale);

        return saleMapper.toDTO(sale);
    }

    public List<SaleDTO> findAll() {
        return elasticSaleRepository.findAll().stream()
                .map(saleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SaleDTO findById(Long id) {
        var maybeSale = elasticSaleRepository.findById(id);
        return maybeSale.map(saleMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    public SaleDTO update(Long id, SaleDTO saleDTO) {
        if(!elasticSaleRepository.existsById(id)){
            throw new RuntimeException("Sale not found");
        }
        var sale = saleMapper.fromDTO(saleDTO);
        sale.setId(id);
        sale = elasticSaleRepository.save(sale);

        return saleMapper.toDTO(sale);
    }

    public String delete(Long id) {
        elasticSaleRepository.deleteById(id);
        return "Sale deleted";
    }
}
