package com.inavan.fc.codestore.modules.product_adm.gateway;

import com.inavan.fc.codestore.modules.product_adm.domain.ProductEntity;

public interface ProductGateway {
    void add(ProductEntity product);
    ProductEntity find(String id);
}
