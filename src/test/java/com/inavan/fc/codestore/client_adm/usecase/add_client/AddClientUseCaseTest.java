package com.inavan.fc.codestore.client_adm.usecase.add_client;

import com.inavan.fc.codestore.modules.client_adm.domain.ClientEntity;
import com.inavan.fc.codestore.modules.client_adm.gateway.ClientGateway;
import com.inavan.fc.codestore.modules.client_adm.usecase.add_client.AddClientInputDto;
import com.inavan.fc.codestore.modules.client_adm.usecase.add_client.AddClientUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddClientUseCaseTest {
    @Mock
    private ClientGateway clientRepository;
    @Test
    void shouldAddAClient() {
        final ClientEntity entity = ClientEntity.builder()
                .name("fulano")
                .email("fulano@gmail.com")
                .address("Rua 1, 1")
                .build();
        Mockito.doNothing().when(clientRepository).add(Mockito.any());

        final var usecase = new AddClientUseCase(clientRepository);
        final var result = usecase.execute(new AddClientInputDto(entity.getId().getId(), entity.getName(), entity.getEmail(), entity.getAddress()));
        Mockito.verify(clientRepository).add(Mockito.any());
        Assertions.assertEquals(entity.getName(), result.name());
    }
}
