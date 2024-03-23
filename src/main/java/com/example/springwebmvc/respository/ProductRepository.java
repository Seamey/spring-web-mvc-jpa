package com.example.springwebmvc.respository;

import com.example.springwebmvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByUuid(String uuid);
    boolean existsByUuid(String uuid);
    void deleteByUuid(String uuid);
}
