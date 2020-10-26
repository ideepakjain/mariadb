package com.learn.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.domain.Product;
import com.learn.services.ProductService;

 

/**
 * Created by jt on 1/10/17.
 */
@RestController
public class ProductController {
	
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/products")
    public List<Product> list() {
        return productService.listAll();
    }
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        try {
            Product product = productService.getById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @PostMapping("/products")
    public void add(@RequestBody Product product) {
    	productService.saveOrUpdate(product);
    }
    
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id) {
        try {
            Product existProduct = productService.getById(id);
            productService.saveOrUpdate(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
    	productService.delete(id);
    }

 
}
