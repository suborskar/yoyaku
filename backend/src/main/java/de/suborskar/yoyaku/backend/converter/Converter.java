package de.suborskar.yoyaku.backend.converter;

public interface Converter<S, T> {
    void convert(S source, T target);

    void reverseConvert(T source, S target);
}
