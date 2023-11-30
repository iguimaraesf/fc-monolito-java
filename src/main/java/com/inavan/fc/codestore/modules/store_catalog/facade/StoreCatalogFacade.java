package com.inavan.fc.codestore.modules.store_catalog.facade;

import com.inavan.fc.codestore.modules.store_catalog.usecase.find_all_products.FindAllProductsUseCase;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_product.FindProductInputDto;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_product.FindProductUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StoreCatalogFacade implements StoreCatalogFacadeInterface {
    private final FindProductUseCase findProductUseCase;
    private final FindAllProductsUseCase findAllProductsUseCase;
    @Override
    public FindStoreCatalogFacadeOutputDto find(FindStoreCatalogFacadeInputDto id) {
        final var res = findProductUseCase.execute(new FindProductInputDto(id.id()));
        return FindStoreCatalogFacadeOutputDto.create(res);
    }

    @Override
    public FindAllStoreCatalogFacadeOutputDto findAll() {
        final var res = findAllProductsUseCase.execute(null);
        return FindAllStoreCatalogFacadeOutputDto.create(res);
    }
}
