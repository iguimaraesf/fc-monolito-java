package com.inavan.fc.codestore.modules.client_adm.usecase.add_client;

import com.inavan.fc.codestore.modules.client_adm.domain.ClientEntity;

import java.time.LocalDateTime;

public record AddClientOutputDto(String id, String name, String email, String address, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static AddClientOutputDto createFromEntity(ClientEntity entity) {
        return new AddClientOutputDto(entity.getId().getId(), entity.getName(), entity.getEmail(), entity.getAddress(), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
