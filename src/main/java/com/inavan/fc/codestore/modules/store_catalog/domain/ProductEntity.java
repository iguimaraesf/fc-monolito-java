package com.inavan.fc.codestore.modules.store_catalog.domain;

import com.inavan.fc.codestore.modules._shared_.domain.entity.AggregeteRoot;
import com.inavan.fc.codestore.modules._shared_.domain.entity.BaseEntity;
import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import com.inavan.fc.codestore.modules.store_catalog.repository.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
// agora tem o preço de venda
public class ProductEntity extends BaseEntity implements AggregeteRoot {
    private String name;
    private String description;
    private Number salesPrice;
    public ProductEntity(ProductModel model) {
        this.setId(new Id(model.getId()));
        this.setCreatedAt(model.getCreatedAt());
        this.setUpdatedAt(model.getUpdatedAt());
        this.name = model.getName();
        this.description = model.getDescription();
        this.salesPrice = model.getSalesPrice();
    }
}
