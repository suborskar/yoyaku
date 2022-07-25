package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import de.suborskar.yoyaku.backend.services.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

public abstract class AbstractCrudService<E extends BaseEntity> implements CrudService<E> {

    @Override
    public E getById(final UUID uuid) throws EntityNotFoundException {
        return getRepository().findById(uuid).orElseThrow(() -> new EntityNotFoundException("No entity found for " + uuid));
    }

    @Override
    public Page<E> getAll(final Specification<E> specification, final Pageable pageable) {
        return getSpecificationExecutor().findAll(specification, pageable);
    }

    @Override
    public E insert(final E entity) {
        return getRepository().save(entity);
    }

    @Override
    public void update(final E entity) throws EntityNotFoundException {
        if (!getRepository().existsById(entity.getUuid())){
            throw new EntityNotFoundException("Could not update entity with " + entity.getUuid() + ". Does not exist");
        }
        getRepository().save(entity);
    }

    @Override
    public void delete(final UUID uuid) {
        getRepository().deleteById(uuid);
    }

    protected abstract JpaRepository<E, UUID> getRepository();

    protected abstract JpaSpecificationExecutor<E> getSpecificationExecutor();
}
