package com.inavan.fc.codestore.modules.product_adm.usecase.check_stock;

import com.inavan.fc.codestore.modules._shared_.domain.usecase.UseCaseInterface;
import com.inavan.fc.codestore.modules.product_adm.facade.CheckStockFacadeInputDto;
import com.inavan.fc.codestore.modules.product_adm.facade.CheckStockFacadeOutputDto;
import com.inavan.fc.codestore.modules.product_adm.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CheckStockUseCase implements UseCaseInterface<CheckStockFacadeInputDto, CheckStockFacadeOutputDto> {
    private final ProductGateway productRepository;
    @Override
    public CheckStockFacadeOutputDto execute(CheckStockFacadeInputDto input) {
        var result = productRepository.find(input.productId());
        return new CheckStockFacadeOutputDto(result.getStock());
    }
}