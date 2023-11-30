package com.inavan.fc.codestore.modules.client_adm.usecase.find_client;

import com.inavan.fc.codestore.modules.client_adm.domain.ClientEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FindClientOutputDto(String id, String name, String email, String address, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public static FindClientOutputDto fromEntity(ClientEntity result) {
        return FindClientOutputDto.builder()
                .id(result.getId().getId())
                .name(result.getName())
                .email(result.getEmail())
                .address(result.getAddress())
                .createdAt(result.getCreatedAt())
                .updatedAt(result.getUpdatedAt())
                .build();
    }
}
