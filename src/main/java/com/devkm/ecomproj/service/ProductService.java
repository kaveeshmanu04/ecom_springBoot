package com.devkm.ecomproj.service;

import com.devkm.ecomproj.model.Product;
import com.devkm.ecomproj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
        //do not return empty product implement status code or ...
    }


    public Product addProduct(Product prod, MultipartFile imageFile) throws IOException {

        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        prod.setImageData(imageFile.getBytes());
        return repo.save(prod);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
