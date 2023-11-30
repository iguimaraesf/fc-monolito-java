package com.inavan.fc.codestore.modules.product_adm.usecase.add_product;

import com.inavan.fc.codestore.modules._shared_.domain.usecase.UseCaseInterface;
import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.product_adm.domain.ProductEntity;
import com.inavan.fc.codestore.modules.product_adm.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddProductUseCase implements UseCaseInterface<AddProductInputDto, AddProductOutputDto> {
    private final ProductGateway productRepository;
    public AddProductOutputDto execute(AddProductInputDto input) {
        final var product = new ProductEntity(new Id(input.id()), input.name(), input.description(),  input.purchasePrice(),  input.stock());
        // adicionar no banco, api, txt...
        this.productRepository.add(product);
        return new AddProductOutputDto(product.getId().getId(), product.getName(), product.getDescription(), product.getPurchasePrice(), product.getStock());
    }
}
