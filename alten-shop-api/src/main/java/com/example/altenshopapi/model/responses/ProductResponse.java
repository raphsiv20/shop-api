package com.example.altenshopapi.model.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse implements Serializable {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private int quantity; //lien de l'image

    private String inventoryStatus;

    private String category;

    private int rating; 
}
