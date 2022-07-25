package de.suborskar.yoyaku.backend.persistence.repositories;

import de.suborskar.yoyaku.backend.persistence.entities.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface BandRepository extends JpaRepository<Band, UUID>, JpaSpecificationExecutor<Band> {
}
