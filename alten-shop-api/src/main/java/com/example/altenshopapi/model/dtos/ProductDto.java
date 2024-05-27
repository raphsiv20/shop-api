package com.example.altenshopapi.model.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6452632333830143700L;

    private Long id;

    private String name;

    private String description;

    private Double price;

    private int quantity;

    private String inventoryStatus;

    private String category;

    private int rating; 
}