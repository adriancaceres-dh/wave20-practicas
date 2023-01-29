package com.example.productos.service;

import com.example.productos.dto.request.ProductoRequestDTO;
import com.example.productos.dto.response.ProductoResponseDTO;
import com.example.productos.model.Producto;
import com.example.productos.repository.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    IProductoRepository productoRepository;

    private ModelMapper mapper = new ModelMapper();

    public ProductoResponseDTO saveProducto(ProductoRequestDTO productoDTO){
        var producto = mapper.map(productoDTO, Producto.class);
        producto = productoRepository.save(producto);
        return mapper.map(producto, ProductoResponseDTO.class);
    }

    public ProductoResponseDTO updateProducto(String id, ProductoRequestDTO productoDTO){
        var producto = productoRepository.findById(id);
        if(producto.isPresent()){
            producto.get().setNombre(productoDTO.getNombre());
            producto.get().setTipo(productoDTO.getTipo());
            producto.get().setPrecioVenta(productoDTO.getPrecioVenta());
            producto.get().setPrecioCosto(productoDTO.getPrecioCosto());
            producto.get().setCantidad(productoDTO.getCantidad());
            productoRepository.save(producto.get());
            return mapper.map(producto, ProductoResponseDTO.class);
        } else
            return null;
    }
}
