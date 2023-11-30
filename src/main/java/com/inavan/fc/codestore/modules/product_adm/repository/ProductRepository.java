package com.inavan.fc.codestore.modules.product_adm.repository;

import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.product_adm.domain.ProductEntity;
import com.inavan.fc.codestore.modules.product_adm.gateway.ProductGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String>, ProductGateway {
    default void add(ProductEntity product) {
        var model = ProductModel.builder().id(product.getId().getId())
                .name(product.getName())
                .description(product.getDescription())
                .purchasePrice(product.getPurchasePrice())
                .stock(product.getStock())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
        this.save(model);
    }
    default ProductEntity find(String id) {
        var model = this.findById(id).orElseThrow();
        var res = ProductEntity.builder()
                .name(model.getName())
                .description(model.getDescription())
                .purchasePrice(model.getPurchasePrice())
                .stock(model.getStock())
                .build();
        res.setId(new Id(model.getId()));
        res.setCreatedAt(model.getCreatedAt());
        res.setUpdatedAt(model.getUpdatedAt());
        return res;
    }
}
