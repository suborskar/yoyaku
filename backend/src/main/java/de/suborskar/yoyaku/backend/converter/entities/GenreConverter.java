package de.suborskar.yoyaku.backend.converter.entities;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.GenreDto;
import de.suborskar.yoyaku.backend.persistence.entities.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter implements Converter<Genre, GenreDto> {
    @Override
    public void convert(final Genre source, final GenreDto target) {
            target.setUuid(source.getUuid());
    }

    @Override
    public void reverseConvert(final GenreDto source, final Genre target) {

    }
}
