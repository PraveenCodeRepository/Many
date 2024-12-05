package com.praveen.ManyToMany_Bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.ManyToMany_Bi.entity.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product, Long> {

}
