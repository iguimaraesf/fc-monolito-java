package com.inavan.fc.codestore.modules.client_adm.domain;

import com.inavan.fc.codestore.modules._shared_.domain.entity.AggregeteRoot;
import com.inavan.fc.codestore.modules._shared_.domain.entity.BaseEntity;
import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.client_adm.repository.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ClientEntity extends BaseEntity implements AggregeteRoot {
    private String name;
    private String email;
    private String address;

    public static ClientEntity createFromModel(ClientModel model) {
        final var entity = ClientEntity.builder()
                .name(model.getName())
                .email(model.getEmail())
                .address(model.getAddress())
                .build();
        entity.setId(new Id((model.getId())));
        entity.setCreatedAt(model.getCreatedAt());
        entity.setUpdatedAt(model.getUpdatedAt());
        return entity;
    }

    public ClientModel toModel() {
        return ClientModel.builder()
                .id(super.getId().getId())
                .name(getName())
                .email(getEmail())
                .address(getAddress())
                .build();
    }
}
