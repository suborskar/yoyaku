package de.suborskar.yoyaku.backend.persistence.repositories;

import de.suborskar.yoyaku.backend.persistence.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID>, JpaSpecificationExecutor<Genre> {
}
