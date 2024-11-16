package com.test.ecom_proj.service;

import com.test.ecom_proj.model.Products;
import com.test.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductsService
{
    @Autowired
    private ProductRepo repo;

    public List<Products> getAllproducts()
    {
        return repo.findAll();
    }

    public Products getProductsById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public Products addProduct(Products product, MultipartFile imageFile) throws IOException
    {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return repo.save(product);
    }


    public Products updateProductById(int id, Products product, MultipartFile imageFile) throws IOException
    {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return repo.save(product);
    }

    public void deleteProductById(int id)
    {
        repo.deleteById(id);
    }

    public List<Products> searchProducts(String keyword)
    {
        return repo.searchProducts(keyword);
    }
}
