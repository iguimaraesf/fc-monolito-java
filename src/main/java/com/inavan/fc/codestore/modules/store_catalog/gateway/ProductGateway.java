package com.inavan.fc.codestore.modules.store_catalog.gateway;

import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;

import java.util.Set;

public interface ProductGateway {
    Set<ProductEntity> findAllProducts();
    ProductEntity findProduct(String id);
}
