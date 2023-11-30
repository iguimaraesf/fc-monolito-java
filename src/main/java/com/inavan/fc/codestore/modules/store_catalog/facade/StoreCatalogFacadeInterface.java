package com.inavan.fc.codestore.modules.store_catalog.facade;

import java.util.Set;

public interface StoreCatalogFacadeInterface {
    FindStoreCatalogFacadeOutputDto find(FindStoreCatalogFacadeInputDto id);
    FindAllStoreCatalogFacadeOutputDto findAll();
}
