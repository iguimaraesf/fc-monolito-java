package com.inavan.fc.codestore.modules.product_adm.facade;

public interface ProductAdmFacadeInterface {
    AddProductFacadeOutputDto addProduct(AddProductFacadeInputDto input);
    CheckStockFacadeOutputDto checkStock(CheckStockFacadeInputDto input);
}
