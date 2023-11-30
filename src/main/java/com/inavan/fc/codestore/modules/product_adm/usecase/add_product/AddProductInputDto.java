package com.inavan.fc.codestore.modules.product_adm.usecase.add_product;

public record AddProductInputDto(String id, String name, String description, Number purchasePrice, Number stock) {
}
