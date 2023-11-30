package com.inavan.fc.codestore.modules._shared_.domain.usecase;

public interface UseCaseInterface<I, O> {
    O execute(I input);
}
