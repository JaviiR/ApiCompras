package com.vila.compras.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.vila.compras.models.ProductModel;
import com.vila.compras.repositories.IProductRepo;

@Service
public class IProductService {

    @Autowired
    private IProductRepo productRepo;

    public ArrayList<ProductModel> getAllProducts() {
        return (ArrayList<ProductModel>) productRepo.findAll();
    }

    public Optional<ProductModel> getProduct(int id) {
        return productRepo.findById(id);
    }

    public ProductModel saveProduct(ProductModel request) {
        return productRepo.save(request);
    }

public ProductModel updateProduct(ProductModel request,int id){
    ProductModel product=new ProductModel();
    product.setId(id);
    product.setName(request.getName());
    product.setDescription(request.getDescription());
    product.setStock(request.getStock());
    product.setPrice(request.getPrice());

    return productRepo.save(product);
}

public boolean deleteProduct(int id){
    try {
        productRepo.deleteById(id);
        return true;
    } catch (Exception e) {
        System.out.println("ERROR: "+e.getMessage());
        return false;
    }
}
}
