package com.rahul.productservice.services;

import com.rahul.productservice.dtos.FakeStoreProductDto;
import com.rahul.productservice.models.Category;
import com.rahul.productservice.models.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// @Service exactly works same as @Component, but it helps us to differentiate between normal components and service classes.

// This class is basically a service class which is useful for actually making a call to the third party service over the network.

// How are we doing this? We are doing this using a class from the spring framework which is known as RestTemplate.

//RestTemplate class gives us various methods such as getForObject(), postForObject(), patchForObject(), etc.

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Converting the DTO into its respective model class in the service class itself is a good practice. Controller class need not be aware of DTOs.

    @Override
    public Product getProductDetails(Long id) {

        FakeStoreProductDto responseDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);

        Product product = new Product();

        product.setId(responseDto.getId());
        product.setTitle(responseDto.getTitle());
        product.setPrice(Double.parseDouble(responseDto.getPrice()));

        Category category = new Category();
        category.setName(responseDto.getCategory());

        product.setCategory(category);

        return product;
    }
}
