package com.inavan.fc.codestore.store_catalog.usecase.find_all_products;

import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;
import com.inavan.fc.codestore.modules.store_catalog.gateway.ProductGateway;
import com.inavan.fc.codestore.modules.store_catalog.usecase.find_all_products.FindAllProductsUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
class FindProductsTest {
    final ProductEntity product1 = ProductEntity.builder()
            .name("onome")
            .description("adesc")
            .salesPrice(12.29)
            .build();
    final ProductEntity product2 = ProductEntity.builder()
            .name("p2")
            .description("adesc p2")
            .salesPrice(49.99)
            .build();
    FindProductsTest() {
        product1.setId(new Id("1"));
        product2.setId(new Id("2"));
    }
    @Mock
    private ProductGateway repository;

    @Test
    void shouldFindAllProducts() {
        Mockito.when(repository.findAllProducts()).thenReturn(Set.of(product1, product2));
        final var useCase = new FindAllProductsUseCase(repository);

        final var result = useCase.execute(null);
        Mockito.verify(repository).findAllProducts();
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.contains(product1));
        Assertions.assertTrue(result.contains(product2));
    }
}
