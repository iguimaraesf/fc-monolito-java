package com.inavan.fc.codestore.product_adm.usecase.add_product;

import com.inavan.fc.codestore.modules.product_adm.gateway.ProductGateway;
import com.inavan.fc.codestore.modules.product_adm.usecase.add_product.AddProductInputDto;
import com.inavan.fc.codestore.modules.product_adm.usecase.add_product.AddProductUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddProductUseCaseTest {
    @Mock
    private ProductGateway productRepository;
    @Test
    void shouldAddAProduct() {
        // use case
        final var useCase = new AddProductUseCase(productRepository);
        // input
        final var input = new AddProductInputDto("1", "Product1", "Product 1 descrutuib", 100, 10);
        final var result = useCase.execute(input);
        // output
        Mockito.verify(productRepository).add(Mockito.any());
        Assertions.assertNotNull(result.id());
        Assertions.assertEquals(input.name(), result.name());
        Assertions.assertEquals(input.description(), result.description());
        Assertions.assertEquals(input.purchasePrice(), result.purchasePrice());
        Assertions.assertEquals(input.stock(), result.stock());
    }
}
