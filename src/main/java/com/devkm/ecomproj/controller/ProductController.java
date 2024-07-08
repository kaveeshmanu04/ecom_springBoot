package com.devkm.ecomproj.controller;

import com.devkm.ecomproj.model.Product;
import com.devkm.ecomproj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile) {
        try {
            Product product1 = service.addProduct(product, imageFile);
            new ResponseEntity<>(product1, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return null;
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImagesByProductId(@PathVariable int productId){
        Product product=service.getProductById(productId);
        byte[] imageFile=product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword){
         List<Product> products=service.searchProducts(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);

    }
}
