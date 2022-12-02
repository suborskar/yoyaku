package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.converter.Converter;
import de.suborskar.yoyaku.backend.dto.GenreDto;
import de.suborskar.yoyaku.backend.persistence.entities.Genre;
import de.suborskar.yoyaku.backend.persistence.entities.LocalizedGenre;
import de.suborskar.yoyaku.backend.persistence.repositories.GenreRepository;
import de.suborskar.yoyaku.backend.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class GenreServiceImpl extends AbstractCrudService<Genre, GenreDto> implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    protected JpaRepository<Genre, UUID> getRepository() {
        return genreRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Genre> getSpecificationExecutor() {
        return genreRepository;
    }

    @Override
    protected Converter<Genre, GenreDto> getConverter() {
        return null;
    }

    @Override
    protected GenreDto createDto() {
        return new GenreDto();
    }

    @Override
    protected Genre createEntity() {
        return new Genre();
    }
}
