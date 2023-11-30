package com.inavan.fc.codestore.product_adm.repository;

import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.product_adm.domain.ProductEntity;
import com.inavan.fc.codestore.modules.product_adm.repository.ProductModel;
import com.inavan.fc.codestore.modules.product_adm.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryMockTest {
    @Mock
    private ProductRepository mockRepo;
    @Test
    void addMethodCallsSave() {
        final var model = ProductEntity.builder()
                .name("a")
                .description("b")
                .purchasePrice(11)
                .stock(0)
                .build();
        Mockito.doCallRealMethod().when(mockRepo).add(Mockito.any());
        mockRepo.add(model);
        Mockito.verify(mockRepo).save(Mockito.any());
    }

    @Test
    void findMethodCallsFindById() {
        final var model = ProductEntity.builder()
                .name("a")
                .description("b")
                .purchasePrice(11)
                .stock(0)
                .build();
        final var idx = "0xx1";
        model.setId(new Id(idx));
        Mockito.doCallRealMethod().when(mockRepo).find(Mockito.eq(idx));
        Mockito.when(mockRepo.findById(Mockito.eq(idx))).thenReturn(Optional.of(new ProductModel()));
        final var res = mockRepo.find(idx);
        Mockito.verify(mockRepo).findById(Mockito.eq(idx));
    }
}
