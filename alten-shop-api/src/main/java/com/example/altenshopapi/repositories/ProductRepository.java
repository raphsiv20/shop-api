package com.example.altenshopapi.repositories;
import com.example.altenshopapi.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    @Query("SELECT p FROM  ProductEntity p ORDER BY p.id ASC")
    Collection<ProductEntity> findAll();

   
}
