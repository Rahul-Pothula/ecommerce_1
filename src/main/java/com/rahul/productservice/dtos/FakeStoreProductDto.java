package com.rahul.productservice.dtos;

// As explained, this DTO class is used so that just in case if there is a change in the third party service which we are using, we just need to change
// the DTO class, and we would not have to change the model class, model class usually shares the same structure as our database structure, so it's not a
// very good idea to change the model classes.

// This class only exists inside the service class FakeStoreProductService class. The rest of the application don't have to know anything about this.

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String price;
    private String category;
    private String image;
}
