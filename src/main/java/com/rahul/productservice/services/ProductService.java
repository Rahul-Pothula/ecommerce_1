package com.rahul.productservice.services;

import com.rahul.productservice.models.Product;

public interface ProductService {
    public Product getProductDetails(Long id);
}