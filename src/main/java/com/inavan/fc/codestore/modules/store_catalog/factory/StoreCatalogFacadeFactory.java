package com.inavan.fc.codestore.modules.store_catalog.factory;

import com.inavan.fc.codestore.modules.store_catalog.facade.StoreCatalogFacade;
import com.inavan.fc.codestore.modules.store_catalog.gateway.ProductGateway;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_all_products.FindAllProductsUseCase;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_product.FindProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StoreCatalogFacadeFactory {
    private final ProductGateway productRepository;
    public StoreCatalogFacade create() {
        final var findProductUseCase = new FindProductUseCase(productRepository);
        final var findAllProductsUseCase = new FindAllProductsUseCase(productRepository);
        return new StoreCatalogFacade(findProductUseCase, findAllProductsUseCase);
    }
}
