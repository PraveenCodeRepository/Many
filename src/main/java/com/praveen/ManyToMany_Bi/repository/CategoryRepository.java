package com.praveen.ManyToMany_Bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.ManyToMany_Bi.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
