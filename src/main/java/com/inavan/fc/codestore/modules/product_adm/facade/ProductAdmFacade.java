package com.inavan.fc.codestore.modules.product_adm.facade;

import com.inavan.fc.codestore.modules._shared_.domain.usecase.UseCaseInterface;
import com.inavan.fc.codestore.modules.product_adm.usecase.add_product.AddProductInputDto;
import com.inavan.fc.codestore.modules.product_adm.usecase.add_product.AddProductOutputDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductAdmFacade implements ProductAdmFacadeInterface{
    private final UseCaseInterface<AddProductInputDto, AddProductOutputDto> addUseCase;
    private final UseCaseInterface<CheckStockFacadeInputDto, CheckStockFacadeOutputDto> stockUseCase;
    @Override
    public AddProductFacadeOutputDto addProduct(AddProductFacadeInputDto input) {
        this.addUseCase.execute(new AddProductInputDto(input.id(), input.name(), input.description(), input.purchasePrice(), input.stock()));
        return new AddProductFacadeOutputDto();
    }

    @Override
    public CheckStockFacadeOutputDto checkStock(CheckStockFacadeInputDto input) {
        return this.stockUseCase.execute(input);
    }
}
