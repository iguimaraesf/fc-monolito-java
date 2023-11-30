package com.inavan.fc.codestore.store_catalog.facade;

import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;
import com.inavan.fc.codestore.modules.store_catalog.facade.FindAllStoreCatalogFacadeOutputDto;
import com.inavan.fc.codestore.modules.store_catalog.facade.FindStoreCatalogFacadeInputDto;
import com.inavan.fc.codestore.modules.store_catalog.facade.FindStoreCatalogFacadeOutputDto;
import com.inavan.fc.codestore.modules.store_catalog.factory.StoreCatalogFacadeFactory;
import com.inavan.fc.codestore.modules.store_catalog.gateway.ProductGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
class StoreCatalogFacadeTest {
    @Mock
    private ProductGateway productRepository;
    @Test
    void shouldFindAProduct() {
        final FindStoreCatalogFacadeOutputDto output = new FindStoreCatalogFacadeOutputDto("1", "nom1", "des1", 11.1);
        final ProductEntity entity = ProductEntity.builder()
                .name(output.name())
                .description(output.description())
                .salesPrice(output.salesPrice())
                .build();
        entity.setId(new Id(output.id()));
        Mockito.when(productRepository.findProduct(Mockito.eq(output.id()))).thenReturn(entity);

        final StoreCatalogFacadeFactory factory = new StoreCatalogFacadeFactory(productRepository);
        final var usecase = factory.create();
        final var result = usecase.find(new FindStoreCatalogFacadeInputDto(output.id()));
        Assertions.assertEquals(output.id(), result.id());
        Assertions.assertEquals(output.salesPrice(), result.salesPrice());
    }

    @Test
    void shouldFindAllProducts() {
        final var fo1 = new FindStoreCatalogFacadeOutputDto("1", "1", "d1", 1.0);
        final var fo2 = new FindStoreCatalogFacadeOutputDto("2", "n2", "d2", 2.0);
        final FindAllStoreCatalogFacadeOutputDto output = new FindAllStoreCatalogFacadeOutputDto(
                Set.of(fo1, fo2)
        );
        final Set<ProductEntity> entities = Set.of(
                ProductEntity.builder().name(fo1.name()).description(fo1.description()).salesPrice(fo1.salesPrice()).build(),
                ProductEntity.builder().name(fo2.name()).description(fo2.description()).salesPrice(fo2.salesPrice()).build()
        );
        Mockito.when(productRepository.findAllProducts()).thenReturn(entities);

        final StoreCatalogFacadeFactory factory = new StoreCatalogFacadeFactory(productRepository);
        final var usecase = factory.create();
        final var result = usecase.findAll();
        Assertions.assertEquals(2, result.products().size());
        Assertions.assertEquals(fo1.salesPrice(), result.products().stream().filter(p -> fo1.name().equals(p.name())).findFirst().orElseThrow().salesPrice());
        Assertions.assertEquals(fo2.salesPrice(), result.products().stream().filter(p -> fo2.name().equals(p.name())).findFirst().orElseThrow().salesPrice());
    }
}
