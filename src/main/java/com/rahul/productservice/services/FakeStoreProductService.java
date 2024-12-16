package com.rahul.productservice.services;

import com.rahul.productservice.dtos.FakeStoreCreateProductDto;
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

        // Actually the below third party call returns a json format data, but the restTemplate takes care of it and automatically converts it into the class
        // specified in the second parameter.

        FakeStoreProductDto responseDto =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreProductDto.class);

        // Here, we are creating a new Product object and not taking the advantage of the application context because we might need multiple such objects.

        Product product = new Product();

        product.setId(responseDto.getId());
        product.setTitle(responseDto.getTitle());
        product.setPrice(Double.parseDouble(responseDto.getPrice()));

        System.out.println(product.getTitle());
        Category category = new Category();
        category.setName(responseDto.getCategory());

        product.setCategory(category);

        return product;
    }

    @Override
    public void createProduct(String title, String description, String image, double price, String category) {
        FakeStoreCreateProductDto requestDto = new FakeStoreCreateProductDto();
        requestDto.setTitle(title);
        requestDto.setDescription(description);
        requestDto.setImage(image);
        requestDto.setPrice(price);
        requestDto.setCategory(category);

        FakeStoreProductDto responseDto = restTemplate.postForObject("http://fakestoreapi.com/products", requestDto, FakeStoreProductDto.class);
    }
}
