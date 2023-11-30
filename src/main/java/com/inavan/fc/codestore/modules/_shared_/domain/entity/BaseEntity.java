package com.inavan.fc.codestore.modules._shared_.domain.entity;

import com.inavan.fc.codestore.modules._shared_.domain.valueobject.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class BaseEntity implements AggregeteRoot {
    private Id id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntity(Id id) {
        this.setId(Optional.ofNullable(id).orElse(new Id()));
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public BaseEntity() {
        this(null);
    }
}
