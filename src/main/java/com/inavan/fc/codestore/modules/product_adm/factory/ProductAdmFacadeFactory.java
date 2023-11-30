package com.inavan.fc.codestore.modules.product_adm.factory;

import com.inavan.fc.codestore.modules.product_adm.facade.ProductAdmFacade;
import com.inavan.fc.codestore.modules.product_adm.gateway.ProductGateway;
import com.inavan.fc.codestore.modules.product_adm.usecase.add_product.AddProductUseCase;
import com.inavan.fc.codestore.modules.product_adm.usecase.check_stock.CheckStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductAdmFacadeFactory {
    private final ProductGateway productReposiitory;

    public ProductAdmFacade create() {
        final var addProductUseCase = new AddProductUseCase(productReposiitory);
        final var checkStockUseCase = new CheckStockUseCase(productReposiitory);
        return new ProductAdmFacade(addProductUseCase, checkStockUseCase);
    }
}
