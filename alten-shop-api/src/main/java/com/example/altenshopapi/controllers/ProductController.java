package com.example.altenshopapi.controllers;

import com.example.altenshopapi.services.ProductService;
import com.example.altenshopapi.model.responses.ProductResponse;
import com.example.altenshopapi.model.requests.ProductRequest;
import com.example.altenshopapi.model.requests.ProductToDeleteRequest;
import com.example.altenshopapi.model.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.*;


@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<ProductResponse>> getAll() {
        Collection<ProductResponse> productResponseCollection = new ArrayList<>();
        for (ProductDto productDto : this.productService.getAll()) {
            ProductResponse productResponse = this.mapper.map(productDto, ProductResponse.class);
            productResponseCollection.add(productResponse);
        }
        return new ResponseEntity<>(productResponseCollection, HttpStatus.OK);
    }

    @GetMapping("/{id}") //get
    public ResponseEntity<ProductResponse> getAProduct(@PathVariable Long id) throws NoSuchElementException {
        ProductResponse productResponse;
        try {
            productResponse = this.mapper.map(this.productService.get(id), ProductResponse.class);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(productResponse, HttpStatus.OK);

    }
    @PostMapping() //create
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse;
        ProductDto productDto = this.mapper.map(productRequest, ProductDto.class);
        productResponse = this.mapper.map(this.productService.create(productDto), ProductResponse.class);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }


    @PatchMapping("/{productId}")
    public void updateAProduct(@RequestBody ProductRequest productRequest, @PathVariable("productId") String productId) {
        ProductDto productDto = this.mapper.map(productRequest, ProductDto.class);
        productDto.setId(Long.parseLong(productId));
        this.productService.update(productDto);
    }

    @DeleteMapping("/delete/aProduct") //delete
    public void deleteAProduct(@RequestBody ProductToDeleteRequest productToDeleteRequest) {
        this.productService.delete(productToDeleteRequest);

    }

    @DeleteMapping("/delete/deleteProducts") //delete
    public void deleteProducts(@RequestBody List<ProductToDeleteRequest> productsToDelete) {
        //System.out.println("DELETE PRODUCT");
        this.productService.deleteProducts(productsToDelete);

    }
}