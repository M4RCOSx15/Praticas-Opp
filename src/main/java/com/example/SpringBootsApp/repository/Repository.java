package com.example.SpringBootsApp.repository;

import com.example.SpringBootsApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Product,Long> {
}
