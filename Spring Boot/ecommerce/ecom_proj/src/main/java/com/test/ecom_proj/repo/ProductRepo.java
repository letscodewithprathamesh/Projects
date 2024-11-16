package com.test.ecom_proj.repo;

import com.test.ecom_proj.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>
{
    @Query("SELECT p from Products p WHERE "+
            "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
            "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
            "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%')) OR "+
            "LOWER(p.category) LIKE LOWER(CONCAT('%',:keyword,'%'))  ")
    List<Products> searchProducts(@Param("keyword") String keyword);
}
