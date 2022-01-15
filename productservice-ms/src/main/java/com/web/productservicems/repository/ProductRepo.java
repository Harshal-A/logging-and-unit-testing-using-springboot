package com.web.productservicems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.productservicems.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
