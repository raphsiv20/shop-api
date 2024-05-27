package com.example.altenshopapi.model.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductToDeleteRequest extends ProductRequest{
    private Long id;
}
