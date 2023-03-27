package com.vila.compras.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vila.compras.models.ProductModel;
import com.vila.compras.services.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    
@Autowired
private IProductService productService;

@GetMapping
public ArrayList<ProductModel> getProducts(){
    return productService.getAllProducts();
}

@GetMapping(path = "/{id}")
public ProductModel getProductById(@PathVariable int id){
    return productService.getProduct(id).get();
}

@PostMapping("/employed")
public ProductModel saveProduct(@RequestBody ProductModel request){
    return productService.saveProduct(request);
}


@PutMapping("employed/{id}") 
public ProductModel updateProduct(@RequestBody ProductModel request,@PathVariable int id){
    return productService.updateProduct(request, id);
}

@DeleteMapping("/{id}")
public boolean deleteProduct(@PathVariable int id){
    return productService.deleteProduct(id);
}

}
