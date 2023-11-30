package com.inavan.fc.codestore.modules.product_adm.domain;

import com.inavan.fc.codestore.modules._shared_.domain.entity.AggregeteRoot;
import com.inavan.fc.codestore.modules._shared_.domain.entity.BaseEntity;
import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductEntity extends BaseEntity implements AggregeteRoot {
    private String name;
    private String description;
    private Number purchasePrice;
    private Number stock;

    public ProductEntity(Id id, String name, String description, Number purchasePrice, Number stock) {
        this(name, description, purchasePrice, stock);
        super.setId(id);
    }
}
