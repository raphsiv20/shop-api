package com.example.altenshopapi.services.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.altenshopapi.model.dtos.ProductDto;
import com.example.altenshopapi.repositories.ProductRepository;
import com.example.altenshopapi.services.ProductService;
import com.example.altenshopapi.model.entities.ProductEntity;
import com.example.altenshopapi.model.requests.ProductToDeleteRequest;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;


@Service
public class ProductServiceIpml implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Collection<ProductDto> getAll() {
        return this.productRepository.findAll().stream()
            .map((productEntity) -> this.mapper.map(productEntity, ProductDto.class))
            .toList();
            
    }

    @Override
    public ProductDto get(Long id) {
        return this.mapper.map(this.productRepository.findById(id).get(), ProductDto.class);
    }

    @Override
    public void update(ProductDto productDto) {
        this.mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        
        this.productRepository.save(this.mapper.map(productDto, ProductEntity.class));
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        if (productDto.getQuantity() == 0) {
            productDto.setInventoryStatus("OUTOFSTOCK");
        } else if (productDto.getQuantity() > 0 && productDto.getQuantity() < 100) {
            productDto.setInventoryStatus("LOWSTOCK");
        } else {
            productDto.setInventoryStatus("INSTOCK");
        }
        ProductEntity productEntity = this.productRepository.save(this.mapper.map(productDto, ProductEntity.class));
        return this.mapper.map(productEntity, ProductDto.class);
    }

    @Override
    public void delete(ProductToDeleteRequest product) {
        this.productRepository.deleteById(product.getId());
    }

    @Override
    public void deleteProducts(List<ProductToDeleteRequest> products) {
        List<Long> productIds = products.stream()
                                        .map(productDto -> productDto.getId())
                                        .toList();
        productRepository.deleteAllById(productIds);

    }
    
}
