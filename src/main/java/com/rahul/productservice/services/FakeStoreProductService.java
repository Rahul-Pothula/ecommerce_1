package com.rahul.productservice.services;

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


    @Override
    public Product getProductDetails(Long id) {
        return null;
    }
}
