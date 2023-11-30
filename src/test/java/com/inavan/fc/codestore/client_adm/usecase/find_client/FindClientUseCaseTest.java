package com.inavan.fc.codestore.client_adm.usecase.find_client;

import com.inavan.fc.codestore.modules.client_adm.domain.ClientEntity;
import com.inavan.fc.codestore.modules.client_adm.gateway.ClientGateway;
import com.inavan.fc.codestore.modules.client_adm.usecase.find_client.FindClientInputDto;
import com.inavan.fc.codestore.modules.client_adm.usecase.find_client.FindClientUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindClientUseCaseTest {
    @Mock
    private ClientGateway clientRepository;
    @Test
    void shouldFindAClient() {
        final ClientEntity entity = ClientEntity.builder()
                .name("fulano")
                .email("fulano@gmail.com")
                .address("Rua 1, 1")
                .build();
        Mockito.when(clientRepository.find(entity.getId().getId())).thenReturn(entity);

        final var usecase = new FindClientUseCase(clientRepository);
        final var result = usecase.execute(new FindClientInputDto(entity.getId().getId()));
        Mockito.verify(clientRepository).find(Mockito.eq(entity.getId().getId()));
        Assertions.assertEquals(entity.getName(), result.name());
    }
}
