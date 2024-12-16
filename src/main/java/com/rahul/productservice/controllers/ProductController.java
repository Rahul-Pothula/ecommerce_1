package com.rahul.productservice.controllers;


// Object should exist as soon as the spring starts, because we will not be able to call the below methods without objects, spring creates
// objects for us and we can make it create by using @Component annotation or @RestController annotation, which is a bit special and
// indicates that this contains the API methods.

import com.rahul.productservice.dtos.CreateProductRequestDto;
import com.rahul.productservice.models.Product;
import com.rahul.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Though, here we are using "Product" to return the Data from the API, it's possible that there could be a sensitive data in it
    // then fronted will receive this sensitive data, for example password, or placement data etc, for this, we use DTO (data transfer objects)
    // all of these objects are stored in a container known as application context, which is maintained bt spring.

    @GetMapping("/products")
    public void getAllProducts() {

    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) {
        System.out.println(id);
        return productService.getProductDetails(id);
    }

    // @RequestBody annotation tells the spring that whatever json it receives from the frontend, it should be converted into the object
    // of the class speciefied right after the "@RequestBody" annotation.

    public void createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {

    }
}
