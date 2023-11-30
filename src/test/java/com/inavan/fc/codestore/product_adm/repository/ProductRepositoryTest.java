package com.inavan.fc.codestore.product_adm.repository;

import com.inavan.fc.codestore.modules.product_adm.repository.ProductModel;
import com.inavan.fc.codestore.modules.product_adm.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @BeforeEach
    void setup() {
        final var bean = ProductModel.builder().
                id("1").
                name("name").
                description("description").
                purchasePrice(100).
                stock(10).
                createdAt(LocalDateTime.now()).
                updatedAt(LocalDateTime.now()).build();
        productRepository.save(bean);
    }

    @Test
    void shouldHaveAProductCreated()  {
        final var result = productRepository.findById("1").orElseThrow();
        Assertions.assertEquals("name", result.getName());
        Assertions.assertEquals("description", result.getDescription());
        Assertions.assertEquals(100, result.getPurchasePrice());
        Assertions.assertEquals(10, result.getStock());
    }

}
