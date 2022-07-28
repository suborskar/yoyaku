package de.suborskar.yoyaku.backend.services;

import de.suborskar.yoyaku.backend.dto.BaseDto;
import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public interface CrudService<E extends BaseEntity, D extends BaseDto>{
    D getById(UUID uuid) throws EntityNotFoundException;

    Page<D> getAll(Specification<E> specification, Pageable pageable);

    D insert(D item);

    void update(D item) throws EntityNotFoundException ;

    void delete(UUID uuid);
}
