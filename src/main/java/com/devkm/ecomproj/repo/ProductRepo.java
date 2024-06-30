package com.devkm.ecomproj.repo;

import com.devkm.ecomproj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
