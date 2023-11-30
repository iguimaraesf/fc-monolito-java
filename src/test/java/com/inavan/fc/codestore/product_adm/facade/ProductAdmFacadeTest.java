package com.inavan.fc.codestore.product_adm.facade;

import com.inavan.fc.codestore.modules.product_adm.domain.ProductEntity;
import com.inavan.fc.codestore.modules.product_adm.facade.AddProductFacadeInputDto;
import com.inavan.fc.codestore.modules.product_adm.facade.CheckStockFacadeInputDto;
import com.inavan.fc.codestore.modules.product_adm.facade.ProductAdmFacade;
import com.inavan.fc.codestore.modules.product_adm.factory.ProductAdmFacadeFactory;
import com.inavan.fc.codestore.modules.product_adm.gateway.ProductGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductAdmFacadeTest {
    @Mock
    private ProductGateway productRepository;
    @Test
    void shouldCreateAProduct() {
//        final UseCaseInterface addProductUseCase = new AddProductUseCase(productRepository);
//        final ProductAdmFacade productAdmFacade = new ProductAdmFacade(addProductUseCase, null);
        final ProductAdmFacade productAdmFacade = new ProductAdmFacadeFactory(productRepository).create();
        final AddProductFacadeInputDto input = new AddProductFacadeInputDto("1", "nome 1", "desc 1", 200, 11);

        productAdmFacade.addProduct(input);
        Mockito.verify(productRepository).add(Mockito.any());
    }

    @Test
    void shouldCheckProductStock() {
        final ProductAdmFacade productAdmFacade = new ProductAdmFacadeFactory(productRepository).create();
        final String idx = "1";
        final AddProductFacadeInputDto input = new AddProductFacadeInputDto(idx, "nome 1", "desc 1", 200, 11);
        Mockito.when(productRepository.find(Mockito.eq(idx))).thenReturn(ProductEntity.builder()
                .name("onome").description("adesc").purchasePrice(1).stock(11)
                .build());
        final var result = productAdmFacade.checkStock(new CheckStockFacadeInputDto(idx));
        Mockito.verify(productRepository).find(Mockito.eq(idx));
        Assertions.assertEquals(input.stock(), result.stock());
    }
}
