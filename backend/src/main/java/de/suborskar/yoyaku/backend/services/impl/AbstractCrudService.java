package de.suborskar.yoyaku.backend.services.impl;

import de.suborskar.yoyaku.backend.dto.BaseDto;
import de.suborskar.yoyaku.backend.persistence.entities.BaseEntity;
import de.suborskar.yoyaku.backend.persistence.entities.I18NBaseEntity;
import de.suborskar.yoyaku.backend.persistence.helpers.LocalizedId;
import de.suborskar.yoyaku.backend.services.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.EntityNotFoundException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public abstract class AbstractCrudService<E extends BaseEntity, D extends BaseDto> implements CrudService<E, D> {

    @Override
    public D getById(final UUID uuid) throws EntityNotFoundException {
        return getRepository().findById(uuid).map(this::mapToDto).orElseThrow(() -> new EntityNotFoundException("No entity found for " + uuid));
    }

    @Override
    public Page<D> getAll(final Specification<E> specification, final Pageable pageable) {
        return getSpecificationExecutor().findAll(specification, pageable).map(this::mapToDto);
    }

    @Override
    public D insert(final D dto) {
        return mapToDto(getRepository().save(mapToEntity(dto)));
    }

    @Override
    public void update(final D dto) throws EntityNotFoundException {
        final Optional<E> entity = getRepository().findById(dto.getUuid());
        final E foundEntity = entity.orElseThrow(() -> new EntityNotFoundException("Could not update entity with " + entity.get().getUuid() + ". Does not exist"));
        mapToEntity(dto, foundEntity);
        getRepository().save(foundEntity);
    }
    @Override
    public void delete(final UUID uuid) {
        getRepository().deleteById(uuid);
    }

    protected <I extends I18NBaseEntity> I getLocalizedEntities(Map<String, I> localizedMap, E entity, String locale, Supplier<I> ctor) {
        I localizedEntity;
        if (localizedMap.containsKey(locale)) {
            localizedEntity = localizedMap.get(locale);
        } else {
            localizedEntity = ctor.get();
            localizedEntity.setLocalizedId(new LocalizedId(locale));
            localizedEntity.setEntity(entity);
            localizedMap.put(locale, localizedEntity);
        }
        return localizedEntity;
    }

    protected  abstract D mapToDto(E entity);

    protected abstract E mapToEntity(D dto);

    protected abstract void mapToEntity(D dto, E entity);


    protected abstract JpaRepository<E, UUID> getRepository();

    protected abstract JpaSpecificationExecutor<E> getSpecificationExecutor();
}
