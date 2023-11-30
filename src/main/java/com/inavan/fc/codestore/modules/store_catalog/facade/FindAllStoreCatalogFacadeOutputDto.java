package com.inavan.fc.codestore.modules.store_catalog.facade;

import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;

import java.util.Set;
import java.util.stream.Collectors;

public record FindAllStoreCatalogFacadeOutputDto(Set<FindStoreCatalogFacadeOutputDto> products) {
    public static FindAllStoreCatalogFacadeOutputDto create(Set<ProductEntity> res) {
        final var lista = res.stream().map(FindStoreCatalogFacadeOutputDto::createFromEntity).collect(Collectors.toSet());
        return new FindAllStoreCatalogFacadeOutputDto(lista);
    }
}
