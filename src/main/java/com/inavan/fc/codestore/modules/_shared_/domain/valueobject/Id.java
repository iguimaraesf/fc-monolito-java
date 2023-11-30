package com.inavan.fc.codestore.modules._shared_.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Id implements ValueObject {
    private String id;

    public Id() {
        setId(UUID.randomUUID().toString());
    }
}
