package com.rahul.productservice.services;

import com.rahul.productservice.dtos.CreateProductRequestDto;
import com.rahul.productservice.models.Product;

public interface ProductService {
    public Product getProductDetails(Long id);

    public void createProduct(String title, String description, String image, double price, String category);
}