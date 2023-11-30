package com.inavan.fc.codestore.modules.store_catalog.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Table(name = "products")
@Entity(name = "ProductSales")
@Immutable
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
    @Column(nullable = false)
    private Number salesPrice;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
