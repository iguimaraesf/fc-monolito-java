package com.inavan.fc.codestore.modules.store_catalog.usecase.find_product;

import com.inavan.fc.codestore.modules._shared_.domain.usecase.UseCaseInterface;
import com.inavan.fc.codestore.modules.store_catalog.gateway.ProductGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindProductUseCase implements UseCaseInterface<FindProductInputDto, FindProductOutputDto> {

    private final ProductGateway repository;
    @Override
    public FindProductOutputDto execute(FindProductInputDto input) {
        return FindProductOutputDto.create(repository.findProduct(input.id()));
    }
}