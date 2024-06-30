package com.devkm.ecomproj.controller;

import com.devkm.ecomproj.model.Product;
import com.devkm.ecomproj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/products")
    public ResponseEntity<List<Product> >getAllProducts(){

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);


    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable int prodId){
        Product product=service.getProductById(prodId);
        if(product != null){
            return new ResponseEntity<>(service.getProductById(prodId),HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
