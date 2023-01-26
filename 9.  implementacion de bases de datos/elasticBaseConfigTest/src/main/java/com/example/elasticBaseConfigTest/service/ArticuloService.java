package com.example.elasticBaseConfigTest.service;

import com.example.elasticBaseConfigTest.domain.Articulo;
import com.example.elasticBaseConfigTest.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<Articulo> getAllArticulos() {
        return StreamSupport.stream(articuloRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Articulo getArticuloByTitle(String titulo) {
        return articuloRepository.findArticuloByTituloEquals(titulo);
    }

}
