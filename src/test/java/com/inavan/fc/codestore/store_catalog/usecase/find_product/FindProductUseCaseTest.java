package com.inavan.fc.codestore.store_catalog.usecase.find_product;

import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;
import com.inavan.fc.codestore.modules.store_catalog.gateway.ProductGateway;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_product.FindProductInputDto;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_product.FindProductUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindProductUseCaseTest {
    @Mock
    private ProductGateway productRepository;

    @Test
    void shouldFindAProduct() {
        final String id = "1";
        Mockito.when(productRepository.findProduct(Mockito.eq(id))).thenReturn(ProductEntity.builder()
                        .name("n1").description("d1").salesPrice(1.0)
                        .build());
        //
        final var usecase = new FindProductUseCase(productRepository);
        final var input = new FindProductInputDto(id);
        final var result = usecase.execute(input);
        Mockito.verify(productRepository).findProduct(Mockito.eq(id));
        Assertions.assertEquals("n1", result.name());
        Assertions.assertEquals(1.0, result.salesPrice());
    }
}
