package com.inavan.fc.codestore.product_adm.factory;

import com.inavan.fc.codestore.modules.product_adm.factory.ProductAdmFacadeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ProductAdmFacadeFactoryTest {
    @Mock
    private ProductAdmFacadeFactory factory;

    @BeforeEach
    void setUp() {
        Mockito.when(factory.create()).thenCallRealMethod();
    }
    @Test
    void factoryShouldCreateFacade() {
        final var facade = factory.create();
        Assertions.assertNotNull(facade);
    }
}