package com.inavan.fc.codestore.modules.client_adm.usecase.find_client;

import com.inavan.fc.codestore.modules._shared_.domain.usecase.UseCaseInterface;
import com.inavan.fc.codestore.modules.client_adm.gateway.ClientGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindClientUseCase implements UseCaseInterface<FindClientInputDto, FindClientOutputDto> {
    private final ClientGateway clientRepository;
    @Override
    public FindClientOutputDto execute(FindClientInputDto input) {
        final var result = clientRepository.find(input.id());
        return FindClientOutputDto.fromEntity(result);
    }
}
