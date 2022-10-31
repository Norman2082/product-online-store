package com.example.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



	@Query("select p from Product p  where p.productName=?1")
   Optional<Product> productByName(String productName);
////
}
