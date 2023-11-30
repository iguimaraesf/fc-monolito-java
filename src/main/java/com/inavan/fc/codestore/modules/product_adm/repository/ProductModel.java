package com.inavan.fc.codestore.modules.product_adm.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "products")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(columnDefinition = "number not null default 0")
    private Number purchasePrice;
    @Column(columnDefinition = "number not null default 0")
    private Number stock;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
