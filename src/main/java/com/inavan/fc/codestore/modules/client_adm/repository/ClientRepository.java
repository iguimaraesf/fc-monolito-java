package com.inavan.fc.codestore.modules.client_adm.repository;

import com.inavan.fc.codestore.modules.client_adm.domain.ClientEntity;
import com.inavan.fc.codestore.modules.client_adm.gateway.ClientGateway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, String>, ClientGateway {
    @Override
    default void add(ClientEntity client) {
        ClientModel model = client.toModel();
        this.save(model);
    }

    @Override
    default ClientEntity find(String id) {
        final var model = this.findById(id).orElseThrow();
        return ClientEntity.createFromModel(model);
    }
}
