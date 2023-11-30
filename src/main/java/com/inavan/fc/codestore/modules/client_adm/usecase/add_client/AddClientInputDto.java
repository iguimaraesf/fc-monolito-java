package com.inavan.fc.codestore.modules.client_adm.usecase.add_client;

import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.client_adm.domain.ClientEntity;

public record AddClientInputDto(String id, String name, String email, String address) {
    public ClientEntity toClientEntity() {
        ClientEntity result = ClientEntity.builder()
                .name(name())
                .email(email())
                .address(address())
                .build();
        result.setId(new Id(id()));
        return result;
    }
}
