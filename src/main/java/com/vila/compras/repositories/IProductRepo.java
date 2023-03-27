package com.vila.compras.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vila.compras.models.ProductModel;

public interface IProductRepo extends JpaRepository<ProductModel,Integer>{
    
}
