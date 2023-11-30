package com.inavan.fc.codestore.modules.client_adm.usecase.add_client;

import com.inavan.fc.codestore.modules._shared_.domain.usecase.UseCaseInterface;
import com.inavan.fc.codestore.modules.client_adm.gateway.ClientGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddClientUseCase implements UseCaseInterface<AddClientInputDto, AddClientOutputDto> {
    private final ClientGateway clientRepository;

    @Override
    public AddClientOutputDto execute(AddClientInputDto input) {
        final var entity = input.toClientEntity();
        clientRepository.add(entity);
        return AddClientOutputDto.createFromEntity(entity);
    }
}
