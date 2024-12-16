package com.rahul.productservice.dtos;

public class FakeStoreCreateProductDto {
    String title;
    String description;
    String image;
    double price;
    String Category;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return Category;
    }
}
