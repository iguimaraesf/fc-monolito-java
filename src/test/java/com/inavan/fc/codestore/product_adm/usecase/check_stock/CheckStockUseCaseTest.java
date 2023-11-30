package com.inavan.fc.codestore.product_adm.usecase.check_stock;

import com.inavan.fc.codestore.modules.product_adm.domain.ProductEntity;
import com.inavan.fc.codestore.modules.product_adm.facade.CheckStockFacadeInputDto;
import com.inavan.fc.codestore.modules.product_adm.gateway.ProductGateway;
import com.inavan.fc.codestore.modules.product_adm.usecase.check_stock.CheckStockUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CheckStockUseCaseTest {
    private ProductEntity product = ProductEntity.builder()
            .name("nomex")
            .description("desc 1ww")
            .purchasePrice(111.2)
            .stock(12)
            .build();
    @Mock
    private ProductGateway productRepository;

    @Test
    void sholdCheckStock() {
        Mockito.when(productRepository.find(Mockito.any())).thenReturn(product);
        // use case
        final var useCase = new CheckStockUseCase(productRepository);
        final var input = new CheckStockFacadeInputDto("1");
        final var output = useCase.execute(input);

        Mockito.verify(productRepository).find(Mockito.any());
        Assertions.assertEquals(product.getStock(), output.stock());
    }

}
