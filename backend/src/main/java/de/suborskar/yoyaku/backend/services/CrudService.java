package de.suborskar.yoyaku.backend.services;

import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public interface CrudService<E extends BaseEntity>{
    E getById(UUID uuid) throws EntityNotFoundException;

    Page<E> getAll(Specification<E> specification, Pageable pageable);

    E insert(E entity);

    void update(E entity) throws EntityNotFoundException ;

    void delete(UUID uuid);
}
