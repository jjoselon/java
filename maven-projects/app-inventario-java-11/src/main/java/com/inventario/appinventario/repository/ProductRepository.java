package com.inventario.appinventario.repository;

import com.inventario.appinventario.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
