package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.persistence.entities.Genre;
import de.suborskar.yoyaku.backend.persistence.repositories.GenreRepository;
import de.suborskar.yoyaku.backend.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenreServiceImpl extends AbstractCrudService<Genre> implements GenreService {
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
}
