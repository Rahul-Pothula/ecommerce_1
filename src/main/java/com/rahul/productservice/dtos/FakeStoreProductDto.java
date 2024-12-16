package com.rahul.productservice.dtos;

// As explained, this DTO class is used so that just in case if there is a change in the third party service which we are using, we just need to change
// the DTO class, and we would not have to change the model class, model class usually shares the same structure as our database structure, so it's not a
// very good idea to change the model classes.

// This class only exists inside the service class FakeStoreProductService class. The rest of the application don't have to know anything about this.

import com.rahul.productservice.models.Category;
import com.rahul.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;


public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Product toProduct() {
        Product product = new Product();

        product.setId(getId());
        product.setTitle(getTitle());
        product.setDescription(getDescription());
        product.setDescription(getDescription());
        product.setPrice(Double.parseDouble(getPrice()));
        product.setImageUrl(getImage());

        Category category = new Category();
        category.setName(getCategory());

        product.setCategory(category);

        return product;

    }
}
