package com.inavan.fc.codestore.store_catalog.repository;

import com.inavan.fc.codestore.modules.store_catalog.domain.ProductEntity;
import com.inavan.fc.codestore.modules.store_catalog.repository.ProductModel;
import com.inavan.fc.codestore.modules.store_catalog.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.Set;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    final ProductModel p1 = ProductModel.builder()
            .id("1")
            .name("nome1")
            .description("desc1")
            .salesPrice(8.1)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    final ProductModel p2 = ProductModel.builder()
            .id("2")
            .name("nome2")
            .description("desc2")
            .salesPrice(8.2)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    @BeforeEach
    void setUp() {
        productRepository.save(p1);
        productRepository.save(p2);
    }

    @Test
    void shouldFindAllProducts() {
        final Set<ProductEntity> res = productRepository.findAllProducts();
        Assertions.assertEquals(2, res.size());
        final var res1 = res.stream().filter(p -> "1".equals(p.getId().getId())).findFirst().orElseThrow();
        Assertions.assertEquals(8.1, res1.getSalesPrice());
        final var res2 = res.stream().filter(p -> "2".equals(p.getId().getId())).findFirst().orElseThrow();
        Assertions.assertEquals(8.2, res2.getSalesPrice());
    }

    @Test
    void shouldFindAProduct() {
        final var res2 = productRepository.findProduct("2");
        Assertions.assertEquals(8.2, res2.getSalesPrice());
    }
}
