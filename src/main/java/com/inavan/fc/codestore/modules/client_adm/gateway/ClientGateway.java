package com.inavan.fc.codestore.modules.client_adm.gateway;

import com.inavan.fc.codestore.modules.client_adm.domain.ClientEntity;

public interface ClientGateway {
    void add(ClientEntity client);
    ClientEntity find(String id);
}
