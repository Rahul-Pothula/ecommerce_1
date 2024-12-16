package com.rahul.productservice.models;

import lombok.Getter;
import lombok.Setter;


public class Category {
    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId(Long id) {
        return id;
    }

    public String getName() {
        return name;
    }
}
