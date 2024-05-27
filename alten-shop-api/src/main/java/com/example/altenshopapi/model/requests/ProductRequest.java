package com.example.altenshopapi.model.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String name;

    private String description;

    private Double price;

    private int quantity;

    private String inventoryStatus;

    private String category;

    private int rating; 
}