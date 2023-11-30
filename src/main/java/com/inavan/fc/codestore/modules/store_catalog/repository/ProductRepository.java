package com.inavan.fc.codestore.modules.store_catalog.repository;


import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;
import com.inavan.fc.codestore.modules.store_catalog.gateway.ProductGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository("salesRepository")
public interface ProductRepository extends JpaRepository<ProductModel, String>, ProductGateway {
    default Set<ProductEntity> findAllProducts() {
        return this.findAll().stream()
                .map(ProductEntity::new)
                .collect(Collectors.toSet());
    };
    default ProductEntity findProduct(String id) {
        return new ProductEntity(this.findById(id).orElseThrow());
    }

}
