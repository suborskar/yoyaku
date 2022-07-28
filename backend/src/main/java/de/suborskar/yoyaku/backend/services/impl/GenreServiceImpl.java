package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.dto.GenreDto;
import de.suborskar.yoyaku.backend.persistence.entities.Genre;
import de.suborskar.yoyaku.backend.persistence.entities.LocalizedGenre;
import de.suborskar.yoyaku.backend.persistence.helpers.LocalizedId;
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
    protected GenreDto mapToDto(final Genre entity) {
        final Locale currentLocale = LocaleContextHolder.getLocale();
        final GenreDto dto = new GenreDto();
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName(currentLocale));
        dto.setDescription(entity.getDescription(currentLocale));
        return dto;
    }

    @Override
    protected Genre mapToEntity(final GenreDto dto) {
        Genre entity = new Genre();
        mapToEntity(dto, entity);
        return entity;
    }

    @Override
    protected void mapToEntity(final GenreDto dto, final Genre entity) {
        final Locale currentLocale = LocaleContextHolder.getLocale();
        LocalizedGenre localizedGenre = getLocalizedEntities(entity.getLocalizations(), entity, currentLocale.getLanguage(), LocalizedGenre::new);
        localizedGenre.setName(dto.getName());
        localizedGenre.setDescription(dto.getDescription());
    }

    @Override
    protected JpaRepository<Genre, UUID> getRepository() {
        return genreRepository;
    }

    @Override
    protected JpaSpecificationExecutor<Genre> getSpecificationExecutor() {
        return genreRepository;
    }
}
