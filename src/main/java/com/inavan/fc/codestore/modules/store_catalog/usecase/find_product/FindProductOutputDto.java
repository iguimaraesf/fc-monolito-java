package com.inavan.fc.codestore.modules.store_catalog.usecase.find_product;

import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;

public record FindProductOutputDto(String id, String name, String description, Number salesPrice) {
    public static FindProductOutputDto create(ProductEntity product) {
        return new FindProductOutputDto(product.getId().getId(), product.getName(), product.getDescription(), product.getSalesPrice());
    }
}
