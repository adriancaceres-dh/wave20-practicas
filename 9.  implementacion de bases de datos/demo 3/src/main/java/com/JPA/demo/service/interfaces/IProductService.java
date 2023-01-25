package com.JPA.demo.service.interfaces;

import com.JPA.demo.dto.ProductDTO;
import com.JPA.demo.service.interfaces.generics.ICrudService;

public interface IProductService extends ICrudService<ProductDTO, Integer> {
}
