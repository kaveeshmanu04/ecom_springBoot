package com.devkm.ecomproj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
    private Date releaseDate;
    private boolean available;
    private int quantity;
}
