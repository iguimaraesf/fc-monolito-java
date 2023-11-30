package com.inavan.fc.codestore.modules.store_catalog.facade;

import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_product.FindProductOutputDto;

// objetos mudam por fazões diferentes
public record FindStoreCatalogFacadeOutputDto(String id, String name, String description, Number salesPrice) {
    public static FindStoreCatalogFacadeOutputDto create(FindProductOutputDto res) {
        return new FindStoreCatalogFacadeOutputDto(res.id(), res.name(), res.description(), res.salesPrice());
    }

    public static FindStoreCatalogFacadeOutputDto createFromEntity(ProductEntity product) {
        return new FindStoreCatalogFacadeOutputDto(product.getId().getId(), product.getName(), product.getDescription(), product.getSalesPrice());
    }
}
