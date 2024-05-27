package com.example.altenshopapi.services;
import com.example.altenshopapi.model.dtos.ProductDto;
import com.example.altenshopapi.model.requests.ProductToDeleteRequest;

import java.util.*;


public interface ProductService {
    Collection<ProductDto> getAll();
    ProductDto get(Long id);
    void update(ProductDto productDto);
    ProductDto create(ProductDto productDto);
    void delete(ProductToDeleteRequest product);
    void deleteProducts(List<ProductToDeleteRequest> products);
}
