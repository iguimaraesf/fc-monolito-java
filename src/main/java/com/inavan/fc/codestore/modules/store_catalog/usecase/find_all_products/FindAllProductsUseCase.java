package com.inavan.fc.codestore.modules.store_catalog.usecase.find_all_products;

import com.inavan.fc.codestore.modules._shared_.domain.usecase.UseCaseInterface;
import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;
import com.inavan.fc.codestore.modules.store_catalog.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class FindAllProductsUseCase implements UseCaseInterface<Void, Set<ProductEntity>> {
    private final ProductGateway repository;
    @Override
    public Set<ProductEntity> execute(Void input) {
        return repository.findAllProducts();
    }
}
